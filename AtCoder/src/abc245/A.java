package abc245;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int tt = a*3600+b*60;
		int ta = c*3600+d*60+1;
		
		if(tt < ta) {
			System.out.println("Takahashi");
		}
		else {
			System.out.println("Aoki");
		}
	}
}
