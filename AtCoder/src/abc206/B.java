package abc206;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = (int)Math.ceil(0.5*(Math.sqrt((long)8*n + 1) - 1));

		System.out.println(result);
	}

}
