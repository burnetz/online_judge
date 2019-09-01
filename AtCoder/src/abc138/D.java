package abc138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int q = Integer.parseInt(tmpArray[1]);

		//節ごとのカウント（値を受け取るだけ。部分木全体には適用しない）
		int counter[] = new int[n + 1];
		//節の親
		int parent[] = new int[n + 1];
		//自分より上（自分含む）の節のカウントの合計
		int total[] = new int[n + 1];

		for(int i = 0; i < n - 1; i++){
			tmpArray = br.readLine().split(" ");

			int a = Integer.parseInt(tmpArray[0]);
			int b = Integer.parseInt(tmpArray[1]);

			parent[b] = a;
		}

		for(int i = 0; i < q; i++){
			tmpArray = br.readLine().split(" ");

			int p = Integer.parseInt(tmpArray[0]);
			int x = Integer.parseInt(tmpArray[1]);

			counter[p] += x;
		}

		//普通にやると間に合わない
		//今回は必ず子供の方が番号が大きいと分かっているので
		//上から計算する際にその節までの合計も記録しておく。
		//これにより全ての祖先を辿らなくても直上の親だけ見ればよくなる
		for(int i = 1; i <= n; i++){
			if(i != 1){
				System.out.print(" ");
			}

			int result = 0;

			result += counter[i];
			result += total[parent[i]];
			total[i] = result;

			System.out.print(result);
		}
		System.out.println();
	}

}
