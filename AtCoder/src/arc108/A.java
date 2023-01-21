package arc108;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long s = sc.nextLong();
		long p = sc.nextLong();

		//x^2 - Sx + P = 0
		//x^2 - (N+M)x + NM = 0

		double b4ac = (double)s*s - 4*p;

		double x1 = (s + Math.sqrt(b4ac))/2;
		double x2 = (s - Math.sqrt(b4ac))/2;

		if(x2 <= 0){
			System.out.println("No");
			return;
		}

		if(Math.floor(x1) == Math.ceil(x1) && Math.floor(x2) == Math.ceil(x2)){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}