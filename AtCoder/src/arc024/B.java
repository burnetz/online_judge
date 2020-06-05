package arc024;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		//あらかじめ2周分の配列を作ると次のステップが楽
		int a[] = new int[2*n];
		
		//初期化のついでに2色使われているかどうかを調べる
		int one = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			a[n + i] = a[i];
			if(a[i] == 1) {
				one++;
			}
		}
		
		//同じ色が連続で最大何本続くか調べる
		//基本的にはバランスを取るたびにこれが一定のペースで小さくなるはず
		int maxLen = 1;
		int tmpLen = 1;
		for(int i = 1; i < 2*n; i++) {
			if(a[i] == a[i - 1]) {
				tmpLen++;
			}
			else {
				maxLen = Math.max(maxLen, tmpLen);
				tmpLen = 1;
			}
		}

		//2色使われているなら一番長い単色区間のバランスを取り終わる日数が答え
		if(one != 0 && one != n) {
			System.out.println((maxLen - 1)/2 + 1);
		}
		//1色しかないなら必ず全部同じ色にしかならず終了できない
		else {
			System.out.println(-1);
		}
	}
}
