package arc067;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if(n == 1){
			System.out.println(1);
			return;
		}

		int[] count = new int[1001];

		for(int i = 2; i <= n; i++){
			int tmp = i;
			int div = 2;

			while(tmp != 1){
				if(tmp % div == 0){
					count[div]++;
					tmp /= div;
				}
				else {
					div++;
				}
			}
		}

		long result = 1;
		int mod = 1_000_000_000 + 7;

		for(int i = 2; i < count.length; i++){
			if(count[i] >= 1){
				result *= count[i] + 1;
				result %= mod;
			}
		}

		System.out.println(result);
	}

}
