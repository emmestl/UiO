import javax.swing.*;

public class TestGUI{

    JFrame ramme;
    JLabel tekst;

    public TestGUI(){

	ramme = new JFrame("Hei-program"); //lager et objekt ramme
	tekst = new JLabel("Haha! jeg fikk det til!"); //lager et objekt tekst

	ramme.add(tekst); //legger til teksten i rammen
	
	ramme.setSize(500, 100); // sier hvor stor rammen skal vaere
	ramme.setVisible(true); //gjor rammen synlig
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
