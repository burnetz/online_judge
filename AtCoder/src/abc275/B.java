package abc275;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		long a[] = new long[6];
		
		int mod = 998244353;
		
		for(int i = 0; i < 6; i++) {
			a[i] = sc.nextLong()%mod;
		}
		
		long abc = a[0]%mod*a[1]%mod*a[2]%mod;
		long def = a[3]%mod*a[4]%mod*a[5]%mod;
		
		while(abc < def) {
			abc += mod;
		}
		
		System.out.println(abc - def);
	}
}
