import javax.swing.*;

public class TesteGUI2{
    JFrame ramme ;
    JLabel tekst ;

    TesteGUI2(){
	ramme = new JFrame("GrubleProg.");
	tekst = new JLabel("Husk at grubling er sunt!");
	ramme.add(tekst);
	ramme.setSize(250, 100);
	ramme.setVisible(true);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
