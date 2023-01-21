package abc185;

import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		SqrtDecompositionRXSQRUQ dec = new SqrtDecompositionRXSQRUQ(n);
		
		int q = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			dec.update(i, i + 1, sc.nextInt());
		}
		
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			int x = sc.nextInt() - 1;
			int y = sc.nextInt();
			
			switch(mode) {
			case 1:
				dec.update(x, x + 1, (int)(dec.get(x)^y));
				break;
			default:
				System.out.println(dec.getSum(x, y));
			}
		}
	}

}

//Range Sum Query用のプログラムをxor sumの計算に合わせて修正すれば再利用できる。
class SqrtDecompositionRXSQRUQ {
	int N, K;
	long[] data;
	long[] bucketSum;
	long[] bucketLazyUpdate;
	static final int sqrtN = 512;
	static final int NIL = Integer.MIN_VALUE;

	public SqrtDecompositionRXSQRUQ(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketLazyUpdate = new long[K];
		Arrays.fill(bucketLazyUpdate, NIL);
		bucketSum = new long[K];
	}

	// [s, t)
	void update(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketLazyUpdate[k] = x;
				bucketSum[k] = x*sqrtN;
			} else {
				if(bucketLazyUpdate[k] != NIL){
					for(int i = l; i < r; i++){
						data[i] = bucketLazyUpdate[k];

					}
					bucketLazyUpdate[k] = NIL;
				}
				for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					data[i] = x;
				}
				bucketSum[k] = 0;
				for(int i = l; i < r; i++){
					bucketSum[k] ^= data[i]; //xor
				}
			}
		}
	}

	//[s,t)
	long getSum(int s, int t) {
		long result = 0;
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				result ^= bucketSum[k]; //xor
			}
			else {
				for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					if(bucketLazyUpdate[k] != NIL){
						result ^= bucketLazyUpdate[k]; //xor
					}
					else {
						result ^= data[i]; //xor
					}
				}
			}
		}

		return result;
	}

	long get(int s) {
		int k = s / sqrtN;
		if(bucketLazyUpdate[k] != NIL){
			return bucketLazyUpdate[k];
		}
		else {
			return data[s];
		}
	}
}