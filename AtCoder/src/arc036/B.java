package arc036;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int inc[] = new int[n];
		int dec[] = new int[n];

		//自分より左の増加列の長さと自分より右の増加列の長さはO(N)で計算可能
		for(int i = 1; i < n; i++){
			if(a[i - 1] < a[i]){
				inc[i] = inc[i - 1] + 1;
			}

			if(a[n - i - 1] > a[n - i]){
				dec[n - i - 1] = dec[n - i] + 1;
			}
		}

		int max = 0;
		for(int i = 0; i < n; i++){
			max = Math.max(max, inc[i] + dec[i] + 1);
		}

		System.out.println(max);
	}
}