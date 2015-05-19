//package imagetesting;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Arrays;


public class Dag7 {

    public static final String IMG = "Santa.png";
    
    public static void main(String[] args) {
	HashMap <Integer, Integer> farger = new HashMap<>();
	BufferedImage img;
	int[] antall;
	

	try {
	    img = ImageIO.read(new File(IMG));
	    for(int i = 0; i< img.getHeight(); i++){
		for (int j = 0; j<img.getWidth(); j++){
		    if(farger.containsKey(img.getRGB(j, i))){
			int n = farger.get(img.getRGB(j, i))+1;
			farger.put (img.getRGB(j, i) , n);
			//System.out.println (farger.get(img.getRGB(j, i)));
		    }
		    else{
			farger.put(img.getRGB(j, i) , 1);
		    }
		}
	    }
	}
	catch (IOException e) {
	    e.printStackTrace();
	}

	antall = new int[farger.size()];
	int teller =0;
	for(Integer s: farger.values()){
	    antall[teller] = s;
	    teller ++;
	}

	Arrays.sort(antall);
	System.out.println(antall[antall.length -10]);
    }
}
