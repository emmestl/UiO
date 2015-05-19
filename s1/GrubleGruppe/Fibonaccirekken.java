public class Fibonaccirekken{
    static int [] ar;

    public static int fib(int n){
	if (n>1){
	    if (ar[n]!=0){
		return ar[n];
	    }
	    int fibN = fib(n-1) + fib(n-2);
	    ar[n] = fibN; 
	    return fibN;
	}
	else {
	    return n;
	}


    }
    public static void main (String [] args){
	int n = 6;
	ar = new int[n+3];
	int fibN = fib(n);
	int sum = fib(n+2)-1;
	
	System.out.println("fib(n) = " +fibN);
	System.out.println ("summen " + sum);

    }
}
	
