package tokiomarine2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long v = sc.nextLong();
		long b = sc.nextLong();
		long w = sc.nextLong();
		long t = sc.nextLong();
		
		if(v <= w) {
			System.out.println("NO");
		}
		else if(Math.abs(a - b) > (v - w)*t) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}

}
