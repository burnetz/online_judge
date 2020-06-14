package abc170;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		boolean[] valid = new boolean[n];
		Arrays.fill(valid, true);

		boolean[] dp = new boolean[1_000_001];
		Arrays.fill(dp, true);
		for(int i = 0; i < n; i++){
			if(!dp[a[i]]){
				continue;
			}
			if(i != 0 && a[i - 1] == a[i]){
				continue;
			}
			else{
				for(int j = 2; j*a[i] < dp.length; j++){
					dp[a[i]*j] = false;
				}
			}
		}
		for(int i = 0; i < n; i++){

			if(i != n - 1 && a[i] == a[i + 1]){
				valid[i] = false;
			}
			if(i != 0 && a[i] == a[i - 1]){
				valid[i] = false;
			}

			if(!dp[a[i]]){
				valid[i] = false;
			}
		}

		int count = 0;
		for(int i = 0; i < n; i++){
			if(valid[i]){
				count++;
			}
		}

		System.out.println(count);
	}
}
