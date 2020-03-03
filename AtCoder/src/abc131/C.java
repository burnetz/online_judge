package abc131;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		long divByC = b/c - (a - 1)/c;
		long divByD = b/d - (a - 1)/d;
		
		long lcmCD = lcm(c, d);
		
		long divByLCM = b/lcmCD - (a - 1)/lcmCD;
		
		System.out.println((b - a + 1) - (divByC + divByD - divByLCM));
	}
	
	static int gcd(int a, int b){
    	int tmp;

    	while (a % b != 0)
    	{
    		tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return b;
    }

    static long lcm(int a, int b, int gcd){
    	return (long)a*(b/gcd);
    }

    static long lcm(int a, int b){
    	int g = gcd(a, b);

    	return lcm(a,b,g);
    }
}
