package codefes2016final;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		boolean solve[] = new boolean[n + 1];
		
		int sum = 0;
		//1問目から順番に足して合計がnを超えたら
		//n-1問目までで不要な問題を抜く。
		//答えは複数パターンあるが、はみ出る値は高々n-1以下なので
		//必ず1問抜くだけでできる。
		for(int i = 1; i <= n; i++) {
			sum += i;
			solve[i] = true;
			
			if(sum >= n) {
				solve[sum - n] = false;
				break;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(solve[i]) {
				System.out.println(i);
			}
		}
	}

}
