package abc179;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long x = sc.nextLong();
		int mod = sc.nextInt();

		if(x == 0){
			System.out.println(0);
			return;
		}

		int appear[] = new int[mod];

		Arrays.fill(appear, -1);

		long sum = x;
		long sumHist[] = new long[mod + 1];
		appear[(int)x] = 0;
		sumHist[0] = x;
		for(int i = 1; i < n; i++){
			x = x*x%mod;

			//f(x,m)の値はm個しか存在しないので、nが十分に大きいならどこかでループに入る
			if(appear[(int)x] != -1){
				int loopLen = i - appear[(int)x];
				//ループが0項目から始まっている場合にREしないよう注意
				long loopSum = sum - (appear[(int)x] > 0 ? sumHist[appear[(int)x] - 1] : 0);

				long remain = n - i;
				long times = (n - i)/loopLen;

				//ループ分をまとめて加算
				sum += loopSum*times;

				//それでも残った分は地道に加算しても十分間に合う
				remain %= loopLen;

				for(int j = 0; j < remain; j++){

					sum += x;
					x = x*x%mod;
				}
				break;
			}
			//ループ検出前は普通に計算。この分岐にしか入らないこともある
			else {
				appear[(int)x] = i;
				sum += x;
				sumHist[i] = sum;
			}
		}

		System.out.println(sum);
	}

}
