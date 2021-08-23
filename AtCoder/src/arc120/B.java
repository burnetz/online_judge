package arc120;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int mod = 998244353;

		char[][] matrix = new char[h][w];
		for(int i = 0; i < h; i++){
			matrix[i] = sc.next().toCharArray();
		}

		long result = 1;

		//部分的に見ても条件が常に成り立つことに注意する。
		//そのためには左下から右上へのマスの並びが1色で構成されている必要がある。
		//（でないとあるマスに対して上から入るのと左から入るので赤の数が変わる）
		//もし.しかない斜めのラインがあればそこは赤青どちらでも可なので答えが2倍になる。
		for(int i = 0; i < w + h ; i++){
			int r = 0;
			int b = 0;
			int dot = 0;

			for(int j = Math.min(i, h - 1); j >= 0; j--){
				int k = i - j;
				if(k >= w){
					break;
				}

				switch(matrix[j][k]){
				case 'R':
					r++;
					break;
				case 'B':
					b++;
					break;
				case '.':
					dot++;
					break;
				}
			}

			if(r*b != 0){
				System.out.println(0);
				return;
			}

			if(r == 0 && b == 0 && dot > 0){
				result *= 2;
				result %= mod;
			}

		}

		System.out.println(result);
	}
}