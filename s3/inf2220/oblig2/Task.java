import java.util.ArrayList;
class Task{

    private final int id;
    private String name;
    private int t;
    private int m;
    private int debth;
    private int antPre;
    private ArrayList<Task> adjenctTasks;
    private int latestStart;
    private int earliestStart;


    public Task(int ID){
	this.id = ID;
	setValues();
    }


    public Task(int ID, String name, int time, int manpower){
	this.id = ID;
	this.name = name;
	t = time;
	m = manpower;
	setValues();
    }

    public void addAdjenct(Task t){
	adjenctTasks.add(t);
    }

    public void setRest(String name, int t, int m){
	this.name = name;
	this.t = t;
	this.m = m;
    }

    public void setAntPre(int antPre){
	this.antPre = antPre;
    }

    //earliest start
    public void setMaxDebth(int debth){
	if(debth > this.debth){
	    this.debth = debth;
	}
    }

    public void setMaxStart(int start){
	if(start > earliestStart){
	    earliestStart = start;
	}
    }

    public void setLatestMinStart(int start){
	if(latestStart == -1){
	    latestStart = start;
	}
	else if(latestStart > start){
	    latestStart = start;
	}

    }

    public int getEarliestStart(){
	return earliestStart;
    }

    public int getLatestStart(){
	return latestStart;
    }

    public int getDebth(){
	return debth;
    }

    public int getID(){
	return id;
    }

    //indegree
    public int getAntPre(){
	return antPre;
    }

    //outdegree
    public int getAntPost(){
	return adjenctTasks.size();
    }

    public ArrayList<Task> getAdjenct(){
	return adjenctTasks;
    }

    public int getTime(){
	return t;
    }

    public int getManpower(){
	return m;
    }

    public String getName(){
	return name;
    }

    public String toString(){
	return id + "";

    }


    private void setValues(){
	adjenctTasks = new ArrayList<>();
	debth = 0;
	latestStart = 0;
	earliestStart = 0;
	latestStart = -1; 
    }
}
