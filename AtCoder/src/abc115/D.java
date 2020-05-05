package abc115;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long x = sc.nextLong();

		String burger = "P";

		len = new long[51];
		len[0] = 1;

		//再帰処理の単純化と高速化のために
		//レベルNバーガーの長さと含まれる全パテの数を計算しておく
		numOfPate = new long[51];
		numOfPate[0] = 1;
		for(int i = 1; i <= 50; i++){
			len[i] = 2*len[i - 1] + 3;
			numOfPate[i] = 2*numOfPate[i - 1] + 1;
		}

		System.out.println(solve(n, x));
	}

	static long len[];
	static long numOfPate[];

	//再帰で解く
	//end : 食べた層の直後のindex
	static long solve(int level, long end){
		long mid = len[level]/2;

		//バンを食べ終わらない
		if(end <= level ){
			return 0;
		}

		//ほぼ全区間とわかっていればこれ以上再帰しなくても出せる
		if(end >= len[level] - level){
			return numOfPate[level];
		}

		//左半分の区間
		long result = solve(level - 1, end - 1);

		//センター分加算
		if(end > mid){
			result++;

			//右半分加算
			result += solve(level - 1, end - mid - 1);
		}

		return result;
	}

}
