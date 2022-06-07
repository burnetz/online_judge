package abc249;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		int x = sc.nextInt();
		
		int distA = x/(a + c)*a*b + Math.min(x%(a + c), a)*b;
		int distB = x/(d + f)*d*e + Math.min(x%(d + f), d)*e;
		
		System.out.println(distA == distB ? "Draw" : 
			distA > distB ? "Takahashi" : "Aoki");
	}		
}

