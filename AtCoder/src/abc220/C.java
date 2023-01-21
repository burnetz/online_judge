package abc220;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		
		long sum = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		
		long x = sc.nextLong();
		
		long result = x/sum*n;
		//順番が違うとオーバーフロー
		x -= result/n*sum;
		
		for(int i = 0; i < n && x >= 0 ; i++) {
			result++;
			x -= a[i];
		}

		System.out.println(result);
	}

}
