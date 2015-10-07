import java.util.ArrayList;
class Project{

    private boolean realizable;
    private ArrayList<Task> start;


    public Project(Task[] input){
	setStart(input);
	realizable = realizable();

    }    
    
    public boolean isRealizable(){
	return realizable;
    }
    
    private boolean realizable(){	
	ArrayList<Task> cycle = new ArrayList<>();
	Task tryThis = start.get(0);

	//check all posible startvalues
	while(tryThis != null){
	    cycle = topSort(cycle, tryThis);
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

    /*tries to topSort the data with the given start*/
    private ArrayList<Task> topSort(ArrayList<Task> cycle, Task tryThis){

	for(int i = 0; i < tryThis.getAntPre(); i ++){
	    //so if all the orther nodes allready has been tried we dont have to do it twice
	    if(start.contains(tryThis.getAdjenct().get(i))){
		cycle = findCycle(cycle, tryThis);
		if(cycle.size() != 0){
		    realizable = false;
		    return cycle;
		}

		break; //dont have to check same node more than once
	    }
	}

	return cycle; //dont want to set to null, cause then we might have to make new one
    }


    
    /*finds the cycle, and in the prosess removes the values that cannot be the start values*/
    //recursive
    private ArrayList<Task> findCycle(ArrayList<Task> cycle, Task t){
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
	    for(int i = 0; i < t.getAntPre(); i ++){
		start.remove(t.getAdjenct().get(i)); //adjenctTasks cannot be the start.
		cycle = findCycle(cycle, t.getAdjenct().get(i));
		//start and finish are the same Task, but not same spot.
		if((cycle.get(0) == cycle.get(cycle.size() -1)) && (cycle.size() != 1)){
		    return cycle;
		}
	    }

	    cycle.remove(t);
	    return cycle;
	}
    }

}
