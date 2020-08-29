package abc177;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		int mod = 1_000_000_007;
		long modsum[] = new long[n];
		//modでも分配法則は成り立つので事前に区間合計を出しておけば効率化できる
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			if(i == 0){
				modsum[i] = a[i];
			}
			else {
				modsum[i] = (a[i] + modsum[i - 1])%mod;
			}
		}

		long result = 0;
		for(int i = n - 1; i > 0; i--){
			result += modsum[i - 1]*a[i]%mod;
			result %= mod;
		}

		System.out.println(result);

	}
}