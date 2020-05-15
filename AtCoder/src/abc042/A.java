package abc042;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		System.out.println(sc.nextInt()*sc.nextInt()*sc.nextInt() == 175 ? "YES" : "NO");
	}
}