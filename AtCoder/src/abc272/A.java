package abc272;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += sc.nextInt();
		}
		
		System.out.println(sum);
	}
}