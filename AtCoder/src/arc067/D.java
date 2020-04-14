package arc067;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int[] x = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
		}

		long result = 0;

		//特にひねりは無く、前から順に進みつつコストが低い方を選べばOK
		for(int i = 1; i < n; i++){
			if((long)a*(x[i] - x[i - 1]) > b){
				result += b;
			}
			else {
				result += a*(x[i] - x[i - 1]);
			}
		}


		System.out.println(result);
	}

}
