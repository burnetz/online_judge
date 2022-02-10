package abc238;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		if(n == 1 || n > 4) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
