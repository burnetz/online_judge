package abc202;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		long k = sc.nextLong() - 1;

		long combination[][] = new long[61][61];
		
		//後の処理のためにコンビネーションのテーブルを作っておく。
		//modが使えないがa+bが十分小さいのでこの方法で作れる。
		for(int i = 0; i < combination.length; i++) {
			combination[i][0] = 1;
		}
		
		for(int i = 1; i < combination.length; i++) {
			for(int j = 1; j <= i; j++) {
				combination[i][j] = combination[i - 1][j - 1] * i / j;
			}
		}
		
		int len = a + b;
		//左から1文字ずつ決めていく。
		//aで始まるグループとbで始まるグループの総数は
		//残りの文字数と上記のテーブルを組み合わせれば求められる。
		for(int i = 0; i < len; i++) {
			//a,bのいずれかが0のときはもう選択肢がないので余っている文字を出力する。
			if(a == 0) {
				System.out.print("b");
				b--;
			}
			else if(b == 0) {
				System.out.print("a");
				a--;
			}
			//i文字目をaにする場合
			else if(k < combination[a - 1 + b][a - 1]) {
				System.out.print("a");
				a--;
			}
			//i文字目をbにする場合。こちらの分岐ではkから上の分岐に相当するパターン数を引く必要がある。
			else {
				System.out.print("b");
				k -= combination[a + b - 1][a - 1];
				b--;
			}
		}
		
		System.out.println();
	}

}
