package panasonic2020;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		//A,B,Cの上限が大きいためdoubleでやるとおそらく合わない。
		//整数型で考えられるよう不等式を変形する。
		if(c - a - b >= 0) {
			if(a*a + b*b + c*c -2*a*b - 2*b*c - 2*c*a > 0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		else {
			System.out.println("No");
		}
	}
}
