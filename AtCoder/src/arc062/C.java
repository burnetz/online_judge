package arc062;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long voteT = sc.nextLong();
		long voteA = sc.nextLong();
		int prevT = (int)voteT;
		int prevA = (int)voteA;
		for(int i = 1; i < n; i++){
			int t = sc.nextInt();
			int a = sc.nextInt();

			//前と比率が変わらないなら1票も入らなかったとみなす
			if(prevT == t && prevA == a){
				continue;
			}

			//後で比の計算をするが、まずT票がtの、A票がaの倍数になっている必要がある
			//当然減らすのではなく増やして修正
			if(voteT % t != 0){
				voteT += t - (voteT % t);
			}

			if(voteA % a != 0){
				voteA += a - (voteA % a);
			}

			//T票が少ない場合は適切な割合を掛ける（なお割り算が先じゃないとオーバーフロー）
			if(voteT < voteA/a*t){
				voteT = voteA/a*t;
			}
			else{
				voteA = voteT/t*a;
			}

			prevT = t;
			prevA = a;
		}

		System.out.println(voteT + voteA);
	}

}
