package abc246;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		double dist = Math.sqrt(a*a + b*b);
		
		System.out.println(a/dist + " " + b/dist);
	}
}