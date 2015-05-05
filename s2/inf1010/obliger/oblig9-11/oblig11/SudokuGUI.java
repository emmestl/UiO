import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SudokuGUI{
    private JFrame ramme;
    private JPanel brettet;
    private JPanel[][] boksene;
    private int vBoks;
    private int lBoks;
    private int boksTeller = 0;
    private int boksRad = 0; //tilsvarer nivået til boksen 
    
    SudokuGUI(int lBoks, int vBoks){
	this.lBoks = lBoks;
	this.vBoks = vBoks;
	
	ramme = new JFrame("Sudokut: " + (vBoks * lBoks) +"x" +(lBoks * vBoks));
	brettet = new JPanel(new GridLayout(vBoks, lBoks));
	boksene = new JPanel[vBoks][lBoks];
	for (int i = 0; i < vBoks; i++){
	    for (int j = 0; j < lBoks; j++){
		boksene[i][j] = new JPanel(new GridLayout(lBoks, vBoks));
		brettet.add(boksene[i][j]);
	    }
	}
	ramme.add(brettet);
	ramme.setSize(300, 300);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void visBrett(){
	ramme.setVisible(true);
    }

    public void leggInnRuter(String verdi){
	System.out.println (boksTeller/lBoks + "   " +boksRad );
	boksene[boksRad/lBoks][boksTeller/vBoks].add(new JLabel(verdi));
	if((++boksTeller)/lBoks >= vBoks){
	    boksTeller = 0;
	    boksRad++;
	}
    }
}
