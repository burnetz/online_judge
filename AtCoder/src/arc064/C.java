package arc064;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int input[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		long total = 0;
		
		//左から見ていって、常に右側から削るのが効率が良い
		for(int i = 1; i < n; i++) {
			//これを満たすときだけ削る必要がある
			if(input[i] + input[i - 1] > x) {
				int remain = input[i] + input[i - 1] - x;
				
				//右側だけを削ればOKな場合
				if(input[i] >= remain) {
					input[i] -= remain;
				}
				//右側だけでは削りきれない場合（左側は二度と見ないので計算不要）
				else {
					input[i] = 0;
				}
				
				total += remain;
			}
		}
		
		System.out.println(total);
	}

}
