import java.util.ArrayList;

class Test{

    public static void main(String[] args) {


	ProjectPlanner p = new ProjectPlanner();
	p.makeProject();


	//for loop;
	/*
	Task[] tasks = new Task[5];
	for(int i = 0; i < tasks.length; i++){
	    tasks[i] = new Task(i, i);
	}

	
	tasks[1].adjenctTasks.add(tasks[0]);
	tasks[0].adjenctTasks.add(tasks[3]);
	tasks[0].adjenctTasks.add(tasks[4]);
	tasks[2].adjenctTasks.add(tasks[1]);
	tasks[4].adjenctTasks.add(tasks[2]);
	*/


	//for doble start without loops

	/*
	
	Task[] tasks = new Task[8];
	for(int i = 0; i < tasks.length; i++){
	    tasks[i] = new Task(i, i +"", i, i,  i);
	}

	tasks[0].adjenctTasks.add(tasks[2]);
	tasks[1].adjenctTasks.add(tasks[2]);
	tasks[1].adjenctTasks.add(tasks[3]);
	tasks[2].adjenctTasks.add(tasks[4]);
	tasks[2].adjenctTasks.add(tasks[5]);
	tasks[3].adjenctTasks.add(tasks[5]);
	tasks[4].adjenctTasks.add(tasks[6]);
	tasks[5].adjenctTasks.add(tasks[6]);
	tasks[5].adjenctTasks.add(tasks[7]);
	
	*/




	//Project p = new Project(tasks);


	
    }
}
