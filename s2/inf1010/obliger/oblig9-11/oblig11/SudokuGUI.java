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

    private JPanel lag1;
    private JPanel lag2;
    private JPanel lag3;
    /*    private JPanel lag4;*/
    private JPanel brettet;
    private JPanel[][] boksene;
    private JButton nesteLosning;


    private int vBoks;
    private int lBoks;
    private int boksTeller = 0;
    private int boksRad = 0; //tilsvarer nivået til boksen
    private int totalAntall;
    private int erPaa = 0;
    
    private SudokuGUI denne = this;

    SudokuGUI(){}

    public static void main(String[] args) throws Exception{
	SudokuGUI sg  = new SudokuGUI();
	sg.lagBrett();
	sg.visLosning();
    }

    
    public void lagBrett(){
	this.brett = new Brett(this);
	
	this.ramme= new JFrame("Sudoku: ");
	ramme.setSize(250, 100);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	lag2 = new JPanel();
	filNavnKnapp = new JButton("Finn lagret fil");

	lag2.add(filNavnKnapp, BorderLayout.CENTER);
	
	ramme.add(lag2);
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
			ramme.remove(lag2);
			lag1 = new JPanel(new BorderLayout());
			ramme.add(lag1);
			
			ramme.setSize(500, 500);
			
			brett.lesFil(filFinner.getSelectedFile().getName());
			synchronized(denne){
			    denne.notify();
			}
		    }

		}
		
	    });
    }

    public void visBrett(Brett b){
	boksRad = 0;
	boksTeller = 0;
	
	for(Rute r: b){
	     leggInnRuter(r.stringVerdi(b.getTallVerdi()));
	}
    }

    public void leggInnRuter(String verdi){
	JLabel rute  = new JLabel(verdi,JLabel.CENTER);
	rute.setBorder(BorderFactory.createLineBorder(Color.black));
	boksene[boksRad/vBoks][boksTeller/lBoks].add(rute);
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
	
	nesteLosning = new JButton("Vis en losninger");

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
    
    public void visLosning()throws Exception{
	synchronized(this){
	    wait();
	}
	
	if(!brett.los()){
	    lag1.removeAll();
	    lag1.add(new JLabel("Brettet har ingen losninger"), BorderLayout.CENTER);
	}
	else{
	    totalAntall = brett.antLosninger();
	    
	    
	    brett.settNeste();
	    nesteLosning.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			erPaa ++;
			
			for (int i = 0; i < lBoks; i++){
			    for (int j = 0; j < vBoks; j++){
				boksene[i][j].removeAll();
			    }
			}
			
			lag1.revalidate();
			brett.utskrift();
			lag1.revalidate();
			nesteLosning.setText("Losning: " + erPaa + "/" + totalAntall);
			lag1.repaint();
		    }
		}
	    );
	}
    }

    public void ingenFlererLosninger(){
	ramme.remove(lag1);
	lag3 = new JPanel();
	lag3.add(new JLabel("Ingen flere losninger", JLabel.CENTER));
	ramme.setSize(250, 100);
	ramme.add(lag3);
	
    }
}

