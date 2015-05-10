import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;

class SudokuGUI{
    private JFrame ramme;
    private JPanel brettet;
    private JPanel[][] boksene;
    private JTextField filNavn;
    private JButton nesteLosning;
    private int vBoks;
    private int lBoks;
    private int boksTeller = 0;
    private int boksRad = 0; //tilsvarer nivået til boksen 

    
    SudokuGUI(int lBoks, int vBoks){
	this.lBoks = lBoks;
	this.vBoks = vBoks;

	JFileChooser filFinner = new JFileChooser();
	FileNameExtensionFilter filer = new FileNameExtensionFilter("Enten en .txt eller .text fil", "txt", "text");
	filFinner.setFileFilter(filer);

	
	ramme = new JFrame("Sudoku: " + (vBoks * lBoks) +"x" +(lBoks * vBoks));
       	ramme.setSize(300, 300);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	filNavn = new JTextField("Filnavn");
	
	filNavn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)

	    });
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
}
