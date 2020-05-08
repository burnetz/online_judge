package abc104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final long mod = 1_000_000_000 + 7;

		char[] input = br.readLine().toCharArray();

		int numOfC[] = new int[input.length];

		for(int i = input.length - 1; i >= 0; i--){
			if(input[i] == 'C' || input[i] == '?'){
				numOfC[i]++;
			}
			if(i != input.length - 1){
				numOfC[i] += numOfC[i + 1];
			}
		}


		//Sの先頭からi-1文字目までに対する処理をすでにおこなっていて
		//これまでにj個○をつけている場合のSの残りの部分に対する処理のパターン数
		long dp[][] = new long[input.length + 1][4];

		//正常に終了した場合、何もしないの1通り
		dp[input.length][3] = 1;

		//○をつけ終わらないのに終了した場合は不正
		for(int j = 0; j < 3; j++){
			dp[input.length][j] = 0;
		}

		//途中で○を3個つけ終わっているなら?を置換するだけ
		for(int i = input.length - 1; i >= 0; i--){
			int m = 1;

			//?なら可能性が3倍
			if(input[i] == '?'){
				m = 3;
			}
			dp[i][3] = m * dp[i + 1][3];
			dp[i][3] %= mod;
		}

		char ABC[] = "ABC".toCharArray();

		for(int i = input.length - 1; i >= 0; i--){
			int m1 = 1;
			int m2 = 0;

			//?なら可能性3倍
			if(input[i] == '?'){
				m1 = 3;
			}

			for(int j = 2; j >= 0; j--){
				//?かあるいはABCのうちの適切な文字でなければ加算できない
				if(input[i] == '?' || input[i] == ABC[j]){
					m2 = 1;
				}
				else {
					m2 = 0;
				}
				//前半の項はi文字目に○をつけない場合
				//後半の項は○をつける場合
				dp[i][j] = m1*dp[i + 1][j] + m2*dp[i + 1][j + 1];
				dp[i][j] %= mod;
			}
		}

		System.out.println(dp[0][0]);
	}

	static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	static void printArray(long[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}


}
