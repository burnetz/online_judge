package arc117;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n + 1];
		int mod = 1_000_000_007;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		//「もともと高かった建物だけを他より低くするのは無理」とわかる。
		//低い順に並べると計算が楽
		Arrays.parallelSort(a);
		
		long result = 1;
		for(int i = n - 1; i >= 0; i--) {
			result *= a[i + 1] - a[i] + 1;
			result %= mod;
		}
		
		System.out.println(result);
	}
}