package arc154;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] strA = sc.next().toCharArray();
		char[] strB = sc.next().toCharArray();
		
		for(int i = 0; i < n; i++) {
			if(strA[i] < strB[i]) {
				char tmp = strA[i];
				strA[i] = strB[i];
				strB[i] = tmp;
			}
		}
		
		long a = 0;
		long b = 0;
		int mod = 998244353;
		
		for(int i = 0; i < n; i++) {
			a *= 10;
			a += strA[i] - '0';
			b *= 10;
			b += strB[i] - '0';
			
			a %= mod;
			b %= mod;
		}
		
		System.out.println(a*b%mod);
	}
}