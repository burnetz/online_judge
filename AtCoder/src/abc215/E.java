package abc215;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();
		char str[] = s.toCharArray();

		//dp[i][j][k]:i文字目の時点で使用済みアルファベットのパターンがj(2進数10桁 + 合計保存用に1つ)
		//k: i文字目を使う(1)使わない(0)
		long dp[][][] = new long[n][1025][2];
		int mod = 998244353;

		dp[0][0][0]++;
		dp[0][1 << cToN(str[0])][1]++;
		dp[0][1024][0] = 1;
		dp[0][1024][1] = 1;

		for(int i = 1; i < n; i++){
			int typeCurrent = cToN(str[i]);

			//i文字目を使わないならi-1文字目までのパターン数をコピー
			for(int j = 0; j <= 1023; j++){
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				dp[i][j][0] %= mod;
			}
			int mask = 1 << typeCurrent;
			for(int j = 0; j <= 1023; j++){
				if((j & mask ) != 0){
					//i番目の文字と同じものを既に使った形跡があるならその場所を全て探し
					//間の文字は無かったものとして足す
					for(int k = i - 1; k >= 0; k--){

						int tmp = cToN(str[k]);
						if(tmp == typeCurrent){
							//文字が一致するにもかかわらずパターン数が0ならもう遡る必要がない
							if(dp[k][j][1] == 0){
								break;
							}
							//同一ビット表記かつk+1文字目からi-1文字目までを全て選ばないパターン数
							dp[i][j][1] += dp[k][j][1];
							dp[i][j][1] %= mod;
						}
					}
				}
				else{
					//直前までその文字を使ったことが無いなら単純に加算
					//maskで表されるビットを初めて見ることになるのでorで計算
					dp[i][(j | mask) ][1] += dp[i - 1][j][0] + dp[i - 1][j][1];
					dp[i][(j | mask) ][1] %= mod;
				}
			}

			for(int j = 0; j <= 1023; j++){
				dp[i][1024][1] += dp[i][j][1];
				dp[i][1024][1] %= mod;

				dp[i][1024][0] += dp[i][j][0];
				dp[i][1024][0] %= mod;
			}
		}

		//dp[i][j][0]の中には1つも選ばないというパターンが存在するので1引く
		System.out.println((dp[n - 1][1024][0] + dp[n - 1][1024][1] + (mod - 1))%mod);

	}

	static int cToN(char c){
		return c - 'A';
	}

}
