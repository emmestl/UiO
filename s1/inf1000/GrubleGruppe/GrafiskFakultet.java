import javax.swing.*;

class GrafiskFakultet {
    static JFrame ramme;
    static JLabel tekst;

    static int  fac(int n){
	if (n>0){
	    int fakultetetAvN = n*fac(n-1);
	    return fakultetetAvN;
	}
	return 1;
    }

    public static void main(String [] args){
	int fakultetet = Integer.parseInt(args[0]);
	int fakultet = fac(fakultetet);
	ramme = new JFrame(args[0] + "!");
	tekst = new JLabel (args[0] + "! = " +fakultet);
	ramme.add(tekst);
	ramme.setSize(250, 100);
	ramme.setVisible(true);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
