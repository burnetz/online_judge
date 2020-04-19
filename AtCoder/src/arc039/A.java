package arc039;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int a23 = a % 100;
		int b23 = b % 100;
		
		//Aのどこかを9に変えるか、bのどこかを0か1に変えるのが良い
		int result = Math.max(900 + a23 - b, a - (b23 + 100));
		
		int a13 = a - a23/10*10;
		int b13 = b - b23/10*10;
		
		result = Math.max(result, Math.max(90 + a13 - b, a - b13));
		
		int a12 = a - a%10;
		int b12 = b - b%10;
		
		result = Math.max(result, Math.max(9 + a12 - b, a - b12));
		
		System.out.println(result);
	}		
}