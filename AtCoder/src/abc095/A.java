package abc095;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		System.out.println((str.split("o", -1).length - 1)*100 + 700);
	}

}
