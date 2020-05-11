package abc084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int n = Integer.parseInt(input);

		int[] c = new int[n-1];
		int[] f = new int[n-1];
		int[] s = new int[n-1];

		//init
		for(int i = 0; i < n -1 ;i++){
			String[] tmpArray = br.readLine().split(" ");
			c[i] = Integer.parseInt(tmpArray[0]);
			f[i] = Integer.parseInt(tmpArray[1]);
			s[i] = Integer.parseInt(tmpArray[2]);
		}

		//i番目の駅からスタート
		for(int i = 0; i < n; i++){
			int time = 0;

			//j番目の駅に乗る
			for(int j = i; j < n - 1; j++){
				//出発時刻の最も早い電車を選ぶ
				int soon = time;

				if(soon <= f[j]){
					soon = f[j];
				}
				else if(soon % s[j] == 0){

				}
				else {
					soon = (soon / s[j] * s[j] + s[j]);
				}

				time = soon + c[j];

			}

			System.out.println(time);
		}
	}

}