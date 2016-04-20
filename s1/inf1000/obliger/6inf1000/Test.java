class Test{
    public static void main(String[] args) {

	Ord ord;
	ord = new Ord();
	
	Ord en;
	en = null;
	
	Ord to;
	to = ord;

	
	System.out.println(ord + "\n" + en +" \n" + to);
	
	ord.oekAntall();

	
	System.out.println(ord + "\n" + en +" \n" + to);

	en = ender(en);
	en = null;

	

	int a = 0;
	int b = 0;
	int c = 0;

	System.out.println (a + "\n" + b + "\n" + c);

	c = a;
	a = 1;
	

	System.out.println (a + "\n" + b + "\n" + c);


	
    } 



    public static  Ord ender (Ord a){

	a.oekAntall();

	return a;
    }
}
