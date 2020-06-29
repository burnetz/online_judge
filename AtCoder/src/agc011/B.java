package agc011;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long a[] = new long[n];
		long sum[] = new long[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextLong();
		}

		Arrays.sort(a);
		sum[0] = a[0];
		for(int i = 1; i < n; i++){
			sum[i] += a[i] + sum[i - 1];

		}

		//もともと一番大きいなら勝てる可能性がある
		int result = 1;
		//勝てる可能性があるということは
		//食べることができる個体を全て食べれば最大のものが相手でも勝てるということと同値
		//i番目の個体から見てsum[i]*2 < a[i + 1]となる場合はi番目以下のサイズは生き残れる見込みがないので
		//何番目以降の個体なら優勝できる可能性があるかを調べる
		for(int i = n - 2; i >= 0; i--){
			if(sum[i]*2 < a[i + 1]){
				result = n - i - 1;
				break;
			}
			else if(i == 0){
				result = n;
			}
		}

		System.out.println(result);
	}
}
