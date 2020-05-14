package abc058;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		for(int i = 0; i < a.length() + b.length(); i++){
			System.out.print(i%2 == 0 ? a.charAt(i/2) : b.charAt(i/2));
		}
		System.out.println();
    }
}