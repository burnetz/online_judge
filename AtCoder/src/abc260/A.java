package abc260;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int t = sc.nextInt();
		int d = sc.nextInt();
		
		System.out.println(t - x*d + Math.min(x, m) * d);
		
	}		
}

