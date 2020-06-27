package agc002;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);


		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a >= 1){
			System.out.println("Positive");
		}
		else if(a <= 0 && b >= 0){
			System.out.println("Zero");
		}
		else{
			System.out.println((Math.min(0, b) - a) % 2 == 1 ? "Positive" : "Negative");
		}
	}

}
