package abc172;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long k = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[m];

		//上から順に時間が少ない方だけを選ぶのは間違い
		//あらゆる読み方の組み合わせを考える必要があるが
		//O(N^2)では間に合わないのでバイナリサーチを使う
		long sumA[] = new long[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			sumA[i] = a[i];
			if(i != 0){
				sumA[i] += sumA[i - 1];
			}

		}

		long sumB[] = new long[m];
		for(int i = 0; i < m; i++){
			b[i] = sc.nextInt();
			sumB[i] = b[i];
			if(i != 0){
				sumB[i] += sumB[i - 1];
			}
		}

		int result = 0;
		for(int i = 0; i < n; i++){
			if(sumA[i] > k){
				break;
			}

			long remain = k - sumA[i];

			int index = Arrays.binarySearch(sumB, remain);

			if(index < 0){
				index = -index - 2;
			}

			result = Math.max(result, i + 1 + index + 1);
		}

		//上記のループではAを全く使わないときに誤答となる
		for(int i = 1; i <= m; i++){
			if(sumB[i - 1] <= k){
				result = Math.max(result, i);
			}
		}
		System.out.println(result);

	}
}