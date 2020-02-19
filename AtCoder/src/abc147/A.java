package abc147;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = sc.nextInt() + sc.nextInt() + sc.nextInt();
		
		if(sum >= 22) {
			System.out.println("bust");
		}
		else {
			System.out.println("win");
		}
	}

}
