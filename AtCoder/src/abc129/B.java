package abc129;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int input[] = new int[n];
		int sum = 0;

		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
			sum += input[i];
		}

		int minDiff = Integer.MAX_VALUE;
		int sum2 = 0;

		for(int i = 0; i < n - 1; i++){
			sum2 += input[i];
			int tmpDiff = Math.abs(sum - sum2*2);

			minDiff = Math.min(tmpDiff, minDiff);
		}

		System.out.println(minDiff);
	}

}
