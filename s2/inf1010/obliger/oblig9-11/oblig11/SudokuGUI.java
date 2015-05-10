import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;

class SudokuGUI{
    //Variabler brukt for innlesning
    private Brett hovedprogramet;
    
    private JFrame ramme;
    private JTextField filNavn;
    private JButton filNavnKnapp;
    private JButton skrivEgen;

    //Variabler brukt ved innlesning og losning
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

    
    SudokuGUI(){
	
	JFileChooser filFinner = new JFileChooser();
	FileNameExtensionFilter filer = new FileNameExtensionFilter("Enten en .txt eller .text fil", "txt", "text");
	filFinner.setFileFilter(filer);

	
	this.ramme= new JFrame("Sudoku: ");
       	ramme.setSize(500, 300);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// legg til ekstra close opperation

	lag1 = new JPanel(new BorderLayout());
	filNavn = new JTextField("Filnavn");
	filNavnKnapp = new JButton("Sok");
	skrivEgen = new JButton("Skriv inn egen Sudoku");

	lag1.add(filNavn, BorderLayout.WEST);
	lag1.add(filNavnKnapp, BorderLayout.EAST);
	lag1.add(skrivEgen, BorderLayout.SOUTH);
	ramme.add(lag1);
	ramme.setVisible(true);

	
	filNavnKnapp.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    String tempTekst = filNavn.getText();
		    lag1.remove(filNavnKnapp);
		    lag1.remove(filNavn);
		    lag1.remove(skrivEgen);
		    
		    ramme.setSize(500, 500);
		    hovedprogramet.lesFil(tempTekst);
		}

	    });
    }
}
/*	skrivEgen.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    new SkrivSudoku({
			    //LAG EN INDRE KLASSE
		    });
		}
	    });
		    
	
	
    }

    public void visBrett(){
	ramme.setVisible(true);
    }

    public void leggInnRuter(String verdi){
	boksene[boksRad/lBoks][boksTeller/vBoks].add(new JLabel(verdi));
	if((++boksTeller)/lBoks >= vBoks){
	    boksTeller = 0;
	    boksRad++;
	}
    }

    public void settStorelse(int v, int l){
	this.lBoks = lBoks;
	this.vBoks = vBoks;

    }

    public void lagOppsettet(){
	nesteLosning = new JButton("Vis en ny losning");

	
	brettet = new JPanel(new GridLayout(vBoks, lBoks));
	boksene = new JPanel[vBoks][lBoks];
	
	for (int i = 0; i < vBoks; i++){
	    for (int j = 0; j < lBoks; j++){
		boksene[i][j] = new JPanel(new GridLayout(lBoks, vBoks));
		brettet.add(boksene[i][j]);
	    }
	}

	//Ber om aa skrive inn filnavn; naar dette er funnet saa endres layouten
	ramme.add(filNavn, BorderLayout.PAGE_END);
	ramme.remove(filNavn);

	
	ramme.add(brettet, BorderLayout.CENTER);
	ramme.add(nesteLosning, BorderLayout.PAGE_END);
    }
}
*/
