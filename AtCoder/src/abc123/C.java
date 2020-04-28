package abc123;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long a[] = new long[5];
		long take[] = new long[5];

		for(int i = 0; i < 5; i++){
			a[i] = sc.nextLong();
			take[i] = (n + a[i] - 1)/a[i];
		}

		long result = take[0];

		//最初の人は必ず毎分行動ができ、合計n分でゴールに行ける
		//最後の人にとって重要なのは各都市における交通手段の効率のみ
		//十分効率が良ければ1分で次の都市に行けるし、
		//そうでなければ最初の人の到着時刻に「その交通手段で全員運ぶのにかかる時間」を足せば良い
		for(int i = 1; i < 5; i++){
			result = Math.max(result + 1, i + take[i] );
		}

		System.out.println(result);
	}

}