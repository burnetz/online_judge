package abc174;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int input[] = new int[n];

		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
		}

		int l = 0;
		int r = 1_000_000_001;

		//結果に対して2分探索で絞り込む
		//最終的な答えがintなので実数まではやらなくて良い。
		while(l < r - 1){
			int mid = (l + r)/2;

			int tmpCount = 0;

			for(int i = 0; i < n; i++){
				tmpCount += (input[i] - 1)/mid;
			}

			if(tmpCount <= k){
				r = mid;
			}
			else {
				l = mid;
			}
		}

		System.out.println(r);
	}

}
