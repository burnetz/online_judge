package abc266;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int mod = 998244353;
		long n = sc.nextLong();
		
		if(n >= 0) {
			System.out.println(n%mod);
		}
		else {
			System.out.println((mod - (-n)%mod)%mod);
		}
	}
}
 
	