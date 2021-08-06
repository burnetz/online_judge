package arc122;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		long sumA = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sumA += a[i];
		}
		
		Arrays.parallelSort(a);
		
		//各minはx = A_i/2を境に減少関数から定数項に変化する
		//いずれの瞬間も全体で見て1次式なので最小値となるxはA_i/2のうちのどれか
		//ソート済みなので順番に計算して確認すれば良い（もっと高速化できそうだがどのみち既にO(NlogN）かかっている
		long sumA2 = 0;
		double result = Double.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			double tmpX = a[i]/2.0;
			double tmpResult = (-n + 2*i)*tmpX + sumA - sumA2;
			result = Math.min(result, tmpResult);
			sumA2 += a[i];
		}
		
		System.out.println(result/n);
	}
}