package abc158;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int p = sc.nextInt();
		char[] input = sc.next().toCharArray();

		int[] pCount = new int[10001];

		long tmp = 0;
		int times = 1;
		long result = 0;

		//pが2か5なら1桁目がpで割れればその先が何桁あっても必ず割り切れる
		if(p == 2 || p == 5){
			for(int j = n - 1; j >= 0; j--){
				if((input[j] - '0') %p == 0){
					result += j + 1;
				}
			}
		}
		//それ以外の場合、x % p == aかつy % p == aのとき(x - y)%p == 0であることを利用する。
		else {
			for(int j = n - 1; j >= 0; j--){
				tmp += (input[j] - '0') * times;

				int mod = (int)(tmp % p);

				result += pCount[mod];

				if(mod == 0){
					result++;
				}


				pCount[mod]++;

				times *= 10;
				//オーバーフロー対策（ただしこれはpが2や5だと使えない）
				times %= p;
			}
		}


		System.out.println(result);
	}
}
