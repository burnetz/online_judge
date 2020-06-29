package agc012;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long a[] = new long[n*3];

		for(int i = 0; i < n*3; i++){
			a[i] = sc.nextLong();
		}
		Arrays.sort(a);
		long result = 0;

		//各グループの1番目と2番目を上から順、3番目を下から順にすれば
		//2番目の和が最大になる
		for(int i = 0; i < n; i++){
			result += a[3*n - 2*i - 2];
		}

		System.out.println(result);
	}
}
