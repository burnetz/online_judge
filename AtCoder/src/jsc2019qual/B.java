package jsc2019qual;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextInt();
		
		int a[] = new int[n];
		
		int mod = 1_000_000_007;
		int max = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			
			max = Math.max(max, a[i]);
		}
		
		//転倒数および逆転倒数（つまりただの増加）を数える
		long tmpResult = 0;
		long tmpResultReverse = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a[j] < a[i]) {
					tmpResult++;
				}
				if(a[j] > a[i]) {
					tmpResultReverse++;;
				}
			}
		}
		
		//長さnの数列を1区間とする。
		//区間をまたがないパターン数は単純にk倍
		//区間を2つ選ぶ方法はk*(k - 1)/2　こちらは逆転頭数も答えに含める必要がある
		System.out.println((tmpResult*k + k*(k - 1)/2%mod*(tmpResult + tmpResultReverse))%mod);
	}

}
