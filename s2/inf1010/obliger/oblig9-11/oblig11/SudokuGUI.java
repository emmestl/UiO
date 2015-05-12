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

    private JPanel brettet;
    private JPanel[][] boksene;
    private JButton nesteLosning;
    private JButton solve;
    private boolean solved = false;

    private JLabel introTekst;
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
    }

    
    public void lagBrett(){
	this.brett = new Brett(this);
	this.ramme= new JFrame("Sudoku: ");
	this.lag2 = new JPanel(new BorderLayout());
	this.filNavnKnapp = new JButton("Finn lagret fil");
	introTekst = new JLabel ("Velkommen til Sudokuloseren", JLabel.CENTER);
	ramme.setSize(250, 100);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	settOppBrett();
	innLesning();
    }

    public void settOppBrett(){
	lag2.add(introTekst, BorderLayout.NORTH);
	lag2.add(filNavnKnapp, BorderLayout.SOUTH);
	ramme.add(lag2);
	ramme.setVisible(true);
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
			solve = new JButton("Los: ");
			lag1.add(solve, BorderLayout.SOUTH);
			los();
		    }

		}
		
	    });
    }

    public void los(){
	solve.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    if(!brett.los()){
			lag1.removeAll();
			lag1.add(new JLabel("Brettet har ingen losninger"), BorderLayout.CENTER);
		    }
		    else{
			totalAntall = brett.antLosninger();
			brett.settNeste();
			nesteLosning = new JButton("Lost");
			lag1.remove(solve);
			lag1.add(nesteLosning, BorderLayout.SOUTH);
			lag1.revalidate();
			lag1.repaint();
			visLosning();
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
	if (verdi.equals(".")){
	    verdi = "";
	}
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


    /* 
     * Fargelegger boksene til riktig farge
     */
    public void lagOppsettet(){
	int farget = 0; //farges ved partall
	
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
    }
    
    public void visLosning(){
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
	    });
    }

    public void ingenFlererLosninger(){
	ramme.remove(lag1);
	ramme.add(lag2);
	introTekst.setText("Ingen flere losninger:");
	erPaa = 0;
	boksRad = 0;
	boksTeller = 0;
	brett = new Brett(this);
	
	ramme.setSize(250, 100);

    }
}

