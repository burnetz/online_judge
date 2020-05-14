package abc056;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		if(b < a){
			int tmp = a;
			a = b;
			b = tmp;
		}

		System.out.println(Math.max(0, b - a - w));
    }
}