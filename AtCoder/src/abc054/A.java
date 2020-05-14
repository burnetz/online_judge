package abc054;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a == 1){
			a = 14;
		}
		if(b == 1){
			b = 14;
		}

		System.out.println(a > b ? "Alice":
			a < b ? "Bob" : "Draw");
	}
}