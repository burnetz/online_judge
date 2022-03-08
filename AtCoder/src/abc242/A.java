package abc242;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		
		if(x <= a) {
			System.out.println(1);
		}
		else if (x > b){
			System.out.println(0);
		}
		else {
			System.out.println((double)c/(b - a));
		}
	}
}
