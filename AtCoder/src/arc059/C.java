package arc059;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		long result = Long.MAX_VALUE;
		//個数も値域も小さいので-100から100まで全てを試しても間に合う
		for(int i = -100; i <= 100; i++) {
			long tmp = 0;
			
			for(int j = 0; j < n; j++) {
				tmp += Math.pow(a[j] - i, 2);
			}
			
			result = Math.min(tmp, result);
		}
		
		System.out.println(result);
	}	
}
