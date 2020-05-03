package abc165;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long n = sc.nextLong();

		if(b == 1){
			System.out.println(0);
			return;
		}

		//x == bのときに第1項と第2項がちょうど一致してしまう
		//その1つ前が最大値
		if(n >= b - 1){
			System.out.println((long)(Math.floor((double)a*(b - 1)/b) - a*Math.floor(((double)b - 1)/b)));
		}
		//結果は一定周期（bの倍数）内で単調増加しているので
		//n < b - 1なら単純にnを代入してよい
		else {
			System.out.println((long)(Math.floor((double)a*n/b) - a*Math.floor(n/b)));
		}
	}
}
