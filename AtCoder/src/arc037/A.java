package arc037;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			result += Math.max(0, 80 - sc.nextInt());
		}
		System.out.println(result);
	}		
}