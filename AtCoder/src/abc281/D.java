package abc281;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		//dp[i][j][k] : i個選んで余りがjになるときの最大の和(k=1はバッファ用)
		//あり得る全ての合計でなく各余りについての最大だけ残せばよい。
		long dp[][][] = new long[k + 1][d][2];
		//i = 0のときはどのjについても合計0と考える。
		//それ以外は未到達として-1で初期化する。
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j < d; j++) {
				for(int l = 0; l < 2; l++) {
					dp[i][j][l] = -1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				for(int l = 0; l < d; l++) {
					if(dp[j - 1][l][0] == -1) {
						continue;
					}
					long tmp = dp[j - 1][l][0] + a[i];
					//代入先は一旦バッファにしないとループ内の以後の計算が狂う。
					dp[j][(int)(tmp%d)][1] = tmp;
					
				}
			}
			//必要に応じてバッファの値で書き換え
			for(int j = 1; j <= k; j++) {
				for(int l = 0; l < d; l++) {
					dp[j][l][0] = Math.max(dp[j][l][1], dp[j][l][0]);
				}
			}
		}
		
		System.out.println(dp[k][0][0]);
	}
}