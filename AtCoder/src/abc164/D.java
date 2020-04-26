package abc164;

import java.util.Scanner;

public class D {

	//やるべきことはABC158 Eと同じ
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		char[] input = str.toCharArray();
		int n = str.length();
		int p = 2019;

		int modCount[] = new int[2019];
		int[] pCount = new int[10001];

		long tmp = 0;
		int times = 1;
		long result = 0;

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

		System.out.println(result);
	}
}
