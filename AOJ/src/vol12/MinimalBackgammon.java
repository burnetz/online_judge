package vol12;

import java.util.Scanner;

public class MinimalBackgammon {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		while(true){
			int n = sc.nextInt();
			int t = sc.nextInt();
			int l = sc.nextInt();
			int b = sc.nextInt();

			if(n == 0){
				break;
			}

			boolean lose[] = new boolean[n + 1];
			boolean back[] = new boolean[n + 1];

			for(int j = 0; j < l; j++){
				lose[sc.nextInt()] = true;
			}

			for(int j = 0; j < b; j++){
				back[sc.nextInt()] = true;
			}

			//nよりも後に1マス休み用の特別なマスを作る
			double[][] dp = new double[t + 1][2*n + 1];
			dp[0][0] = 1;

			for(int i = 0; i < t; i++){
				for(int j = 0; j < 2*n + 1; j++){
					//一度クリアしたなら動かず確率引き継ぎ
					if(j == n){
						dp[i + 1][j] += dp[i][j];
						continue;
					}
					//待機専用マスにいたら必ず本来のマスに戻る
					else if(j > n){
						dp[i + 1][j - n] += dp[i][j];
						continue;
					}
					double tmp = dp[i][j] / 6;
					for(int k = 1; k <= 6; k++){
						int next;

						next = j + k;

						//nを超えている可能性があるので戻り分計算
						if(next > n){
							next = n - (next - n);
						}

						//普通に移動したり、行き過ぎて戻った先が特殊マスの可能性がある
						if(lose[next]){
							next += n;
						}
						else if(back[next]){
							next = 0;
						}

						//いろいろなパターンがあったが出発地が同じなら行き先が異なっても加算する値は基本的に同じ
						dp[i + 1][next] += tmp;
					}
				}

			}

			//指数表記不可
			System.out.printf("%.6f\n",dp[t][n]);
		}
	}

}
