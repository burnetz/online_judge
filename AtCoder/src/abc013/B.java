package abc013;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int result;

		if(b >= a){
			result = Math.min(b - a, a - b + 10);
		}
		else {
			result = Math.min(a - b, b - a + 10);
		}
		System.out.println(result);
	}
}