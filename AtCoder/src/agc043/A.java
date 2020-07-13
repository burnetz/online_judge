package agc043;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char[][] input = new char[h][w];

		for(int i = 0; i < h; i++){
			input[i] = sc.next().toCharArray();
		}

		int[][] dp = new int[h][w];

		if(input[0][0] == '#'){
			dp[0][0] = 1;
		}
		//DPで解くことが可能
		//白いマスから黒いマスに入るときだけコストが増える
		//連続で黒いマスなら既にまとめて反転したことで操作がいらないため
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(i != 0 || j != 0){
					dp[i][j] = Integer.MAX_VALUE;
				}

				if(i != 0){
					dp[i][j] = dp[i - 1][j];
					if(input[i][j] == '#' && input[i - 1][j] == '.'){
						dp[i][j]++;
					}
				}

				if(j != 0){
					int tmpDp;
					if(input[i][j] == '#' && input[i][j - 1] == '.'){
						tmpDp = dp[i][j - 1] + 1;
					}
					else {
						tmpDp = dp[i][j - 1];
					}
					dp[i][j] = Math.min(dp[i][j], tmpDp);
				}

			}
		}

		System.out.println(dp[h - 1][w - 1]);
	}
}
