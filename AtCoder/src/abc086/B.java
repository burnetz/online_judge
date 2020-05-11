package abc086;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		int num = Integer.parseInt(a + b);

		System.out.println(Math.pow((int)Math.sqrt(num), 2) == num ? "Yes" : "No");

	}
}
