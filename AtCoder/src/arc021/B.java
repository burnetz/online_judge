package arc021;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();

		int b[] = new int[l];

		for(int i = 0; i < l; i++){
			b[i] = sc.nextInt();
		}

		int result[] = new int[l];

		//答えが複数あると言っても各桁の01が反転するだけ
		//なので最初の数字は0であると決め打ち可能。
		//あとは矛盾がないように次の数字を作っていく
		for(int i = 1; i < l; i++){
			int mask = 1;

			for(int j = 0; j < 31; j++){
				if((b[i - 1]&mask) != (result[i - 1]&mask)){
					result[i] |= mask;
				}

				mask <<= 1;
			}
		}

		if((result[0]^result[l - 1]) == b[l - 1]){
			for(int i = 0; i < l ; i++){
				System.out.println(result[i]);
			}
		}
		//最初と最後のxorがb[l - 1]にならないなら与えられた数列が間違い
		else{
			System.out.println(-1);
		}
	}
}
