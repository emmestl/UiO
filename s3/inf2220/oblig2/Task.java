import java.util.ArrayList;
class Task{

    private final int id;
    private String name;
    private int t;
    private int m;
  
    private int antPre;  
    private ArrayList<Task> adjenctTasks;

    
    public Task(int ID){
	this.id = ID;
	adjenctTasks = new ArrayList<>();
    }

    
    public Task(int ID, String name, int time, int manpower){
	this.id = ID;
	this.name = name;
	t = time;
	m = manpower;
	adjenctTasks = new ArrayList<>();
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

    public int getID(){
	return id;
    }

    public int getAntPre(){
	return antPre;
    }

    public ArrayList<Task> getAdjenct(){
	return adjenctTasks;
    }
    
    public String toString(){
	return id + "";
	
    }

}
