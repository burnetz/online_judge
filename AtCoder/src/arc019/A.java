package arc019;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String price = sc.next();

		price = price.replace("O", "0");
		price = price.replace("D", "0");
		price = price.replace("I", "1");
		price = price.replace("Z", "2");
		price = price.replace("S", "5");
		price = price.replace("B", "8");

		System.out.println(price);
	}
}
