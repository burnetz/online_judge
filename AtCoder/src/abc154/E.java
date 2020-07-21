package abc154;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String numStr = sc.next();
		int K = sc.nextInt();
		
		int len = numStr.length();
		
		//dp[i][j][k] 上からi桁まで見て、そこまでで非零をj回使い、
		//k = 0 : そこまでNと一致している場合 k = 1 : そこまででk以下が確定しているとき
		int dp[][][] = new int[len + 1][K + 1][2];
		dp[0][0][0] = 1;
		
		for(int i = 0; i < len; i++) {
			int tmpNum = numStr.charAt(i) - '0';
			for(int j = 0; j <= K; j++) {
				for(int k = 0; k <= 1; k++) {
					//次の桁の各数字について次の状態を考える
					for(int l = 0; l <= 9; l++) {
						//桁は必ず1増える
						int nextI = i + 1;
						int nextJ = j;
						//非零の回数を更新
						if(l > 0) {
							nextJ++;
							if(nextJ > K) {
								continue;
							}
						}
						int nextK = k;
						//直前までNと一致していた場合
						if(k == 0) {
							//確実にNをオーバーする
							if(l > tmpNum) {
								continue;
							}
							//確実にNより小さくなる
							if(l < tmpNum) {
								nextK = 1;
							}
						}
						//もともとk=1なら何を選んでもNより小さいままなので状態遷移不要
						
						dp[nextI][nextJ][nextK] += dp[i][j][k];
					}
				}
			}
		}
		
		System.out.println(dp[len][K][0] + dp[len][K][1]);
	}
}
