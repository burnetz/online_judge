package abc129;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		final int MOD = 1_000_000_000 + 7;

		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean broken[] = new boolean[n + 1];

		for(int i = 0; i < m; i++){
			broken[sc.nextInt()] = true;
		}

		//2連続で壊れていたらたどり着けない
		for(int i = 1; i < n; i++){
			if(broken[i] && broken[i - 1]){
				System.out.println(0);
				return;
			}
		}

		long result[] = new long[n + 1];
		result[0] = 1;

		if(!broken[1]){
			result[1] = 1;
		}
		for(int i = 2; i <= n; i++){
			if(broken[i]){
				result[i] = 0;
			}
			else {
				result[i] = (result[i - 1] + result[i - 2])%MOD;
			}
		}

		System.out.println(result[n]);
	}
}
