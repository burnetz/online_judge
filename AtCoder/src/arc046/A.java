package arc046;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		for(int i = 0; i <= (n - 1) / 9; i++) {
			System.out.print((n - 1)%9 + 1);
		}
		System.out.println();
	}
}