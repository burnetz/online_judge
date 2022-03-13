package abc243;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		while(v >= 0) {
			v -= a;
		
			if(v < 0) {
				System.out.println("F");
				return;
			}
			v -= b;
			if(v < 0) {
				System.out.println("M");
				return;
			}
			v -= c;
			if(v < 0) {
				System.out.println("T");
				return;
			}
		}
	}
}
