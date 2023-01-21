package arc107;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		//count[i] : a+bでiを作ることができる数字のパターン数
		long count[] = new long[400_001];
		
		for(int i = 2; i < count.length; i++) {
			if(i <= n + 1) {
				count[i] = i - 1;
			}
			else if(i <= 2*n) {
				count[i] = 2*n - i + 1;
			}
		}
		
		long result = 0;
		for(int i = 2; i <= 2*n; i++) {
			if(i - k <= 0) {
				continue;
			}
			//K = (a + b) - (c + d)と考えるとパターン数は以下で計算可能
			result += count[i] * count[i - k];
		}
		
		System.out.println(result);
	}
}