package abc206;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int n2 = (int)(1.08*n);

		System.out.println(n2 < 206 ? "Yay!" :
			n2 == 206 ? "so-so" : ":(");
	}

}
