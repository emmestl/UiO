import java.util.*;
class Project2{

    private boolean realizable;
    private ArrayList<Task> start;
    private HashMap<Integer, ArrayList<Task>> times;
    private Task[] tasks;
    //private ArrayList<ArrayList<Task>> topSort;

    public Project2(Task[] input){
	tasks = input;
	setStart(input);
	//setTopsort();
	realizable = realizable();
    }


    public void doProject(){
	optimalTimeSchedule();
	int absLatest = printTimeSchedule();
	slackSchedule(absLatest);
	printTaskInfo();

    }

    public boolean isRealizable(){
	return realizable;
    }

    private boolean realizable(){
	ArrayList<Task> cycle = new ArrayList<>();

	/*There is no start, therfore a loop, but might start at a tree-end witch apares as a tree.
	  Add therefor all the nodes as possible starts for the loop. When found it stops anyway*/
	if(start.size() == 0){
	    for(Task t: tasks){
		start.add(t);
	    }
	}
	
	Task tryThis = start.get(0);

	//check all posible startvalues
	while(tryThis != null){
	    cycle = findCycle(cycle, tryThis);
	    if(!isRealizable(cycle)){
		printCycle(cycle);
		return false;

	    }

	    tryThis = getNewTask(tryThis);
	}

	return true;
    }


    private boolean isRealizable(ArrayList<Task> cycle){
	return cycle.size() == 0;
    }

    /*
      private void setTopsort(){
      topSort = new ArrayList<>();
      topSort.add(start);
      }
    */
    private void setStart(Task[] input){
	start = new ArrayList<>();

	for (int i = 0; i < input.length; i++){
	    if(input[i].getAntPre() == 0){
		start.add(input[i]);
	    }
	}

    }

    private Task getNewTask(Task old){
	int index = start.indexOf(old);
	if(++index  < start.size()){
	    return start.get(index);
	}

	return null; //tried all posibilities
    }




    private void printCycle(ArrayList<Task> cycle){
	for(int i = 0; i < cycle.size(); i++){
	    System.out.println (cycle.get(i));
	}

    }

    /*
      private void printTopSort(){

      for(ArrayList<Task> tasks: topSort){
      for(Task t: tasks){
      System.out.print(t + " ");
      }
      System.out.println ();
      }
      }
    */


    private void printTaskInfo(){
	for(Task t : tasks){
	    System.out.println ("-----------------------------");
	    System.out.println ("TaskID: " + t.getID() + "\n");
	    System.out.println ("Name: " + t.getName());
	    System.out.println ("Manpower: " + t.getManpower());
	    System.out.println ("Duration time: " + t.getTime() +"\n");
	    System.out.println ("Earliest start time: " + t.getEarliestStart());
	    System.out.println ("Latest start time: " + t.getLatestStart());
	    System.out.println ("Slack: " + (t.getLatestStart() - t.getEarliestStart() ));

	    System.out.println ("-----------------------------\n");
	}
    }

    private int printTimeSchedule(){
	ArrayList<Task> running = new ArrayList<>();
	int manpower = 0;
	int[] startFinnish = sort();
	for(int j = 0; j < startFinnish.length; j ++){
	    int i = startFinnish[j];

	    //removing duplicate times
	    if(j == 0 || startFinnish[j-1] != startFinnish[j] ){

		System.out.println ("Time " + i + ":");

		for(int k = 0; k < running.size(); k++){
		    if(running.get(k).getEarliestStart() + running.get(k).getTime() == i){
			System.out.println("\tFinished: " + running.get(k));
			manpower -= running.get(k).getManpower();
			running.remove(running.get(k));
		    }
		}

		if(times.containsKey(i)){
		    for(Task t: times.get(i)){
			System.out.printf ("\tStarting: %s\n", t);
			running.add(t);
			manpower += t.getManpower();
		    }
		}
		System.out.println ("\tCurrent Staff: " + manpower);
	    }
	}

	System.out.println ("\n**** Shortest possible project execution is " + startFinnish[startFinnish.length -1]+ " ****");

	return startFinnish[startFinnish.length -1];
    }


    /*add all the start and finishing times to an array*/
    private int[] sort(){
	//every start has a finnish
	int[] startFinnish = new int[times.keySet().size() + tasks.length];

	int i = 0;
	for(int startTime: times.keySet()){
	    startFinnish[i++] = startTime;
	    for(Task t: times.get(startTime)){
		startFinnish[i++] = t.getEarliestStart() + t.getTime();
	    }
	}

	Arrays.sort(startFinnish);

	return startFinnish;
    }
    /*tries to topSort the data with the given start*/

    private ArrayList<Task> findCycle(ArrayList<Task> cycle, Task tryThis){

	cycle = findCycle(cycle, tryThis, 0); //debth 0 for start nodes

	realizable = cycle.size() == 0;
	return cycle; //dont want to set to null, cause then we might have to make new one
    }

    /*
      private void addNodeToDebth(Task t, int debth){
      System.out.println (t);
      t.setAntPre(t.getAntPre() - 1);
      t.setMaxDebth(debth);
      if(t.getAntPre() != 0){ //there are stil more nodes pointing to this node
      return;
      }



      if(topSort.size() == debth){
      topSort.add(new ArrayList<>());
      }

      if(topSort.get(t.getDebth()) == null){
      topSort.add(new ArrayList<>());
      }

      topSort.get(t.getDebth()).add(t);

      }
    */

    /*finds the cycle, and in the prosess removes the values that cannot be the start values*/
    //recursive
    private ArrayList<Task> findCycle(ArrayList<Task> cycle, Task t, int debth){
	//addNodeToDebth(t, debth);
	//true = we have a cycle!
	if(cycle.contains(t) && cycle.size() > 1){
	    int index = cycle.indexOf(t);
	    cycle.add(t);

	    for(int i = 0; i < index; i++){
		cycle.remove(i);
	    }

	    return cycle;
	}


	else{
	    cycle.add(t);
	    for(int i = 0; i < t.getAntPost(); i ++){
		//start.remove(t.getAdjenct().get(i)); //adjenctTasks cannot be the start.
		cycle = findCycle(cycle, t.getAdjenct().get(i), debth + 1);
		//start and finish are the same Task, but not same spot.
		if((cycle.get(0) == cycle.get(cycle.size() -1)) && (cycle.size() != 1)){
		    return cycle;
		}
	    }

	    cycle.remove(t);
	    return cycle;
	}
    }

    private void optimalTimeSchedule(){
	times = new HashMap<>();
	for(Task t: start){
	    optimalTimeSchedule(t);
	}

	for(Task t: tasks){
	    addToTime(t);
	}
    }

    private void optimalTimeSchedule(Task t){
	for(Task adjenctTasks: t.getAdjenct()){
	    adjenctTasks.setMaxStart(t.getEarliestStart() + t.getTime());
	    optimalTimeSchedule(adjenctTasks);
	}

    }


    private void addToTime(Task t){
	if(!times.containsKey(t.getEarliestStart())){
	    times.put(t.getEarliestStart(), new ArrayList<Task>());
	}
	if(!times.get(t.getEarliestStart()).contains(t)){
	    times.get(t.getEarliestStart()).add(t);
	}
    }

    private void slackSchedule(int absLatest){
	for(Task t: start){
	    slackSchedule(t, absLatest);
	}
    }

    //recursive
    private int slackSchedule(Task t, int absLatest){
	//Not at the bottom jet
	if(t.getAdjenct().size() != 0){
	    for(Task adjenct : t.getAdjenct()){
		t.setLatestMinStart(slackSchedule(adjenct, absLatest) - t.getTime());
	    }
	}

	System.out.println ("Task " + t + "\t time " + t.getLatestStart());

	if(t.getAdjenct().size() == 0){
	    t.setLatestMinStart(absLatest - t.getTime());
	}
	return t.getLatestStart();
    }
}
