package abc156;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int input[] = new int[n];

		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
		}

		long total = Long.MAX_VALUE;
		for(int i = 1; i <= 100; i++){
			long tmpTotal = 0;
			for(int j = 0; j < n; j++){
				tmpTotal += (input[j] - i)*(input[j] - i);
			}

			total = Math.min(total, tmpTotal);
		}

		System.out.println(total);
	}

}
