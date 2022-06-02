package abc253;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long sum = n*(n+1)/2;
		
		long na = n/a;
		long nb = n/b;
		
		long sumA = (2*a + (na - 1)*a)*na/2;
		long sumB = (2*b + (nb - 1)*b)*nb/2;
				
		long ab = lcm((int)a, (int)b);
		long nab = n/(ab);
		long sumAB = (2*ab + (nab - 1)*ab)*nab/2;

		//1からNまでの合計 - Aの倍数の合計 - Bの倍数の合計 + A,BのLCMの倍数の合計が求める値
		sum = sum - sumA - sumB + sumAB;
		
		System.out.println(sum);
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