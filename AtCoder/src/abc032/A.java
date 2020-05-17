package abc032;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long lcm = lcm(sc.nextInt(), sc.nextInt());
		System.out.println((sc.nextInt() + lcm - 1)/lcm*lcm);
	}

	static long lcm(int a, int b, int gcd){
    	return (long)a*(b/gcd);
    }

    static long lcm(int a, int b){
    	int g = gcd(a, b);

    	return lcm(a,b,g);
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
}