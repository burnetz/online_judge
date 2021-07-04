package arc110;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long lcm = 2;

		for(int i = 3; i <= n; i++){
			lcm = lcm(lcm, i);
		}

		System.out.println(lcm + 1);
	}

	static long lcm(long a, long b, long gcd){
    	return (long)a*(b/gcd);
    }

    static long lcm(long a, long b){
    	long g = gcd(a, b);

    	return lcm(a,b,g);
    }

	static long gcd(long a, long b){
        long tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}