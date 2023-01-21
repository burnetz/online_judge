package abc209;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int c[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		
		int mod = 1_000_000_007;
		
		Arrays.sort(c);
		
		long result = c[0];
		
		for(int i = 1; i < n; i++) {
			result *= c[i] - i;
			result %= mod;
		}
		
		System.out.println(result);
	}

}
