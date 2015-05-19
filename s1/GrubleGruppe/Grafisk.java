import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafisk{
    
    JFrame ramme;
    JPanel panel;
    JTextField inText;
    JLabel outText;
    JButton knapp;

    ramme = new JFrame();
    inText = new JTextField("", 20);
    outText = new JLabel();
    knapp = new JButton("Trykk pa meg!");
    panel = new JPanel();

    panel.add(inText);
    panel.add(knapp);
    panel.add(outText);
    ramme.add(panel);
	

    knapp.addActionListener(new Lytter());
	
    ramme.setSize(250, 500);
    ramme.setVisible(true);
    ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
class Lytter implements ActionListener {
    public void actionPerformed(ActionEvent e){
	String tastet = inText.getText();
	outText.setText(" Du tastet '" + tastet + "'");
    }
}
