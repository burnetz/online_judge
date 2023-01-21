package abc194;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 0;

		if(a + b >= 15 && b >= 8) {
			result = 1;
		}
		else if(a + b >= 10 && b >= 3) {
			result = 2;
		}
		else if(a + b>= 3) {
			result = 3;
		}
		else {
			result = 4;
		}
		
		System.out.println(result);
	}

}
