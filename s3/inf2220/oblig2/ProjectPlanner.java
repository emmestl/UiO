import java.util.*;
import java.io.*;

class ProjectPlanner{
    private Project p;
    private Task[] tasks;
    private String file;

    public void makeProject(String file){
	this.file = file;
	readFile();
	p = new Project(tasks);

	p.doProject();
    }


    public void readFile(){
	Scanner fil = checkFile();

	tasks = new Task[Integer.parseInt(fil.nextLine())];

	makeTask(fil);
    }



    private void makeTask(Scanner fil){
	int index = 0;

	
	while(fil.hasNextLine() && (index < tasks.length)){
	    if(tasks[index] ==  null){ //the task is not allready made    
		tasks[index] = new Task(fil.nextInt(), fil.next(), fil.nextInt(), fil.nextInt());
	    }
	    else{
		tasks[fil.nextInt() - 1].setRest(fil.next(), fil.nextInt(), fil.nextInt());
	    }
	    
	    int in = fil.nextInt();
	    int ant = 0;

	    while(in != 0){
		ant ++;
		//to fill index 0, ID starts at 1
		if (tasks[in -1] == null){
		    tasks[in -1] = new Task(in);
		}
		
		tasks[in -1 ].addAdjenct(tasks[index]);
		
		in = fil.nextInt();

	    }

	    tasks[index].setAntPre(ant);
	    index++;
	}

    }

    private Scanner checkFile(){
	Scanner fil;
	try{
	    fil = new Scanner(new File(file));
	}
	catch(FileNotFoundException e){
	    System.out.println ("file not fount");
	    System.exit(0);
	    return null; //because Java complaines otherways
	}

	return fil;
    }

}
