package abc163;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);


		int n = sc.nextInt();
		int k = sc.nextInt();

		long total = 0;
		int mod = 1_000_000_007;

		for(int i = k; i <= n + 1; i++){
			long bottom = sumSeq(0, i - 1);
			long top = sumSeq(n - i + 1, n);

			total += top - bottom + 1;
			total %= mod;

//			System.out.println("i = "+i+" total = "+total+ " bottom = " + bottom + " top = "+top);
		}

		System.out.println(total);

	}

	static long sumSeq(int a, int b){
		return ((long)b - a + 1)*(a + b)/2;
	}
}
