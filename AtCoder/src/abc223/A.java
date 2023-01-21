package abc223;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		if(x >= 100 && x % 100 == 0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
