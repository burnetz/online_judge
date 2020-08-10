package vol23;

import java.util.Scanner;

public class SightseeingTour {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int input[][] = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				input[i][j] = sc.nextInt();
			}
		}

		//完全グラフは辺の方向をどう決めてもハミルトン路になるので
		//コストが低い方の辺を選び続ければよい
		long result = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				result += Math.min(input[i][j], input[j][i]);
			}
		}

		System.out.println(result);
	}

}
