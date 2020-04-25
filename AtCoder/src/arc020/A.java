package arc020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		a = Math.abs(a);
		b = Math.abs(b);

		if(a == b){
			System.out.println("Draw");
		}
		else if(a < b){
			System.out.println("Ant");
		}
		else {
			System.out.println("Bug");
		}
	}
}
