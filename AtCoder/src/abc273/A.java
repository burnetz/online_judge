package abc273;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int result = 1;
		for(int i = 2; i <= n; i++) {
			result *= i;
		}
		System.out.println(result);
	}
}