package abc248;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long k = sc.nextLong();
		
		int count = 0;
		while(a < b) {
			a *= k;
			count++;
		}
		
		System.out.println(count);
	}
}