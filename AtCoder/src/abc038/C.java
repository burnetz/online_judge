package abc038;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//dp[i] : i番目の数字で終わる単調増加列の個数
		long dp[] = new long[n];
		dp[0] = 1;

		long result = 1;
		for(int i = 1; i < n; i++){
			if(a[i - 1] < a[i]){
				dp[i] = dp[i - 1] + 1 ;
			}
			else {
				dp[i] = 1;
			}
			result += dp[i];
		}

		System.out.println(result);
	}
}

