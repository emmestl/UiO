import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class SudokuGUI{
    private Brett brett;

    private JFrame ramme;
    private JButton filNavnKnapp;
    private JButton skrivEgen;

    private JPanel lag1;
    private JPanel lag2;
    private JPanel lag3;
    private JPanel lag4;
    private JPanel brettet;
    private JPanel[][] boksene;
    private JButton nesteLosning;


    private int vBoks;
    private int lBoks;
    private int boksTeller = 0;
    private int boksRad = 0; //tilsvarer nivået til boksen


    SudokuGUI(){}

    public static void main(String[] args){
	SudokuGUI sg  = new SudokuGUI();
	sg.lagBrett();
    }

    
    public void lagBrett(){
	this.brett = new Brett(this);
	
	this.ramme= new JFrame("Sudoku: ");
	ramme.setSize(500, 300);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// legg til ekstra close opperation

	lag1 = new JPanel(new BorderLayout());
	filNavnKnapp = new JButton("Finn lagret fil");
	skrivEgen = new JButton("Skriv inn egen Sudoku");


	lag1.add(filNavnKnapp, BorderLayout.NORTH);
	lag1.add(skrivEgen, BorderLayout.SOUTH);
	ramme.add(lag1);
	ramme.setVisible(true);
	innLesning();
    }

    
    public void innLesning(){
	filNavnKnapp.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    JFileChooser filFinner = new JFileChooser(new File(System.getProperty("user.dir")));
		    FileNameExtensionFilter filer = new FileNameExtensionFilter("Enten en .txt eller .text fil", "txt", "text");
		    filFinner.setFileFilter(filer);
		    if(filFinner.showOpenDialog(ramme) == JFileChooser.APPROVE_OPTION) {
			 lag1.remove(filNavnKnapp);
			 lag1.remove(skrivEgen);
		    
			 ramme.setSize(500, 500);
			 
			 brett.lesFil(filFinner.getSelectedFile().getName());
			 lagOppsettet();
			 visLosning();
		    }

		}
		
	    });
    }

/*skrivEgen.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	new SkrivSudoku({
	//LAG EN INDRE KLASSE
	});
	}
	});



	}
*/
    public void visBrett(Brett b){
	for(Rute r: b){
	    leggInnRuter(r.stringVerdi(b.getTallVerdi()));
	}
    }

    public void leggInnRuter(String verdi){
	boksene[boksRad/vBoks][boksTeller/lBoks].add(new JLabel(verdi));
	if((++boksTeller)/vBoks >= lBoks){
	    boksTeller = 0;
	    boksRad++;
	}
    }

    public void settStorelse(int v, int l){ 
	this.lBoks = l;
	this.vBoks = v;
    }

    public void lagOppsettet(){
	int farget = 0; //farges ved partall
	
	nesteLosning = new JButton("Vis en ny losning");

	brettet = new JPanel(new GridLayout(lBoks, vBoks));
	boksene = new JPanel[lBoks][vBoks];
	
	for (int i = 0; i < lBoks; i++){
	    for (int j = 0; j < vBoks; j++){
		boksene[i][j] = new JPanel(new GridLayout(vBoks, lBoks));

		if(farget %2 == 0){
		    boksene[i][j].setBackground(Color.LIGHT_GRAY);
		}
		
		brettet.add(boksene[i][j]);
		farget++;
	    }
	    
	    if((vBoks)%2 == 0){
		farget = farget %2 +1;
	    }
	}
	
	// bare for aa faa litt penere kanter
	lag1.add(new JPanel(), BorderLayout.NORTH); 
	lag1.add(new JPanel(), BorderLayout.WEST);
	lag1.add(new JPanel(), BorderLayout.EAST);
		
	lag1.add(brettet, BorderLayout.CENTER);
	lag1.add(nesteLosning, BorderLayout.SOUTH);
    }
    
    public void visLosning(){
	if(!brett.los()){
	    lag1.add(new TextField("Brettet har ingen losninger"), BorderLayout.CENTER);
	}
	else{
	    nesteLosning.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			brett.utskrift();
		    }
		}
	    );
	}
    }
}

