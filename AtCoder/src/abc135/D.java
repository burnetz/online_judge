package abc135;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		int mod = 1_000_000_007;
		//modCount[i][j] : 左からi文字の時点におけるmod 13=jとなる組み合わせの数
		long modCount[][] = new long[str.length][13];

		//数字を10倍、100倍...するために使う
		int geta = 1;
		for(int i = str.length - 1; i >= 0; i--){
			//任意の数字を入れられるとき
			if(str[i] == '?'){
				for(int j = 0; j <= 9; j++){
					int tmp = j*geta % 13;
					//乗算と加算はmodが保存されるのでn桁の整数は最上位の桁とn-1桁の数字に分けて考えられる
					if(i < str.length - 1){
						for(int k = 0; k < 13; k++){
							modCount[i][(tmp + k) % 13] += modCount[i + 1][k];
							modCount[i][(tmp + k) % 13] %= mod;
						}
					}
					else {
						modCount[i][j] = 1;
					}
				}
			}
			//入れられる数字を固定されている場合
			else {
				int num = str[i] - '0';
				int tmp = num*geta%13;

				if(i == str.length - 1){
					modCount[i][tmp] = 1;
				}
				else {
					for(int j = 0; j < 13; j++){
						modCount[i][(tmp + j)%13] += modCount[i + 1][j];
						modCount[i][(tmp + j)%13] %= mod;
					}
				}
			}

			//10倍するだけだとオーバーフローするのでmodだけを保存する
			geta *= 10;
			geta %= 13;
		}

		System.out.println(modCount[0][5]);

	}

}
