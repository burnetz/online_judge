package abc181;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int w[] = new int[m];
		
		for(int i = 0; i < m; i++) {
			w[i] = sc.nextInt();
		}
		
		//先生がどの形態を選ぶとしても最適解は昇順で前からペアを組ませること。
		//それ以外の方法だと数直線で考えたときに同じ区間を複数回カウントすることになる。
		Arrays.sort(a);
		//先生はソートする必要なかったかも
		Arrays.sort(w);
		
		//生徒は奇数人なので1番目から組ませて最後が余る場合の和と
		//2番目から組ませて最初が余る場合の和を求めておく。
		long oddSum[] = new long[n];
		long evenSum[] = new long[n];
		
		for(int i = 1; i < n; i++) {
			oddSum[i] = oddSum[i - 1];
			evenSum[i] = evenSum[i - 1];
			
			if(i % 2 == 1) {
				oddSum[i] += a[i] - a[i - 1];
			}
			else {
				evenSum[i] += a[i] - a[i - 1];
			}
		}
		
		long result = Long.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			//この場合は先生が必ず1番目の生徒と組む。
			if(w[i] <= a[0]) {
				result = Math.min(result, a[0] - w[i] + evenSum[n - 1]);
			}
			//この場合は先生が必ずn番目の生徒と組む。
			else if(w[i] >= a[n - 1]) {
				result = Math.min(result, w[i] - a[n - 1] + oddSum[n - 1]);
			}
			//途中に先生が割って入る場合。
			else {
				int index = Arrays.binarySearch(a, w[i]);
				
				if(index < 0) {
					index = -(index + 1);
				}
				//割り込む先が偶数番目か奇数番目かによって少し式が変わる。
				if(index % 2 == 0) {
					long tmp = (a[index] - w[i]) + oddSum[index - 1] + (evenSum[n - 1] - evenSum[index]);
					result = Math.min(result, tmp);
				}
				else {
					long tmp = (w[i] - a[index - 1] ) + oddSum[index - 1] + (evenSum[n - 1] - evenSum[index]);
					result = Math.min(result, tmp);					
				}
			}
		}
		
		System.out.println(result);
	}

}
