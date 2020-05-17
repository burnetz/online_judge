package abc035;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();

		System.out.println(w%16 == 0 && h%9 == 0 ? "16:9" : "4:3");
	}
}