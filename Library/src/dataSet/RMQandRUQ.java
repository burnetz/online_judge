package dataSet;

import java.util.Arrays;
import java.util.Scanner;

//AOJ DSL_2_Fで動作確認済
public class RMQandRUQ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();

		SqrtDecompositionRMQRUQ sq = new SqrtDecompositionRMQRUQ(n);
		sq.update(0, n, Integer.MAX_VALUE);
		for(int i = 0; i < q; i++){
			int type = sc.nextInt();

			if(type == 0){
				int s = sc.nextInt();
				int t = sc.nextInt();
				int x = sc.nextInt();

				sq.update(s, t + 1, x);
			}
			else {
				int s = sc.nextInt();
				int t = sc.nextInt();

				System.out.println(sq.findMin(s, t + 1));
			}

		}
	}

}

class SqrtDecompositionRMQRUQ {
	int N, K;
	long[] data;
	long[] bucketMin;
	long[] bucketLazyUpdate;
	static final int sqrtN = 512;
	static final int NIL = Integer.MIN_VALUE;

	public SqrtDecompositionRMQRUQ(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketLazyUpdate = new long[K];
		Arrays.fill(bucketLazyUpdate, NIL);
		bucketMin = new long[K];
	}

	// [s, t)
	void update(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketLazyUpdate[k] = x;
				bucketMin[k] = x;
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
				bucketMin[k] = Long.MAX_VALUE;
				for(int i = l; i < r; i++){
					bucketMin[k] = Math.min(bucketMin[k], data[i]);
				}
			}
		}
	}

	long findMin(int s, int t) {
		long result = Long.MAX_VALUE;
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				result = Math.min(result, bucketMin[k]);
			}
			else {
				if(bucketLazyUpdate[k] != NIL){
					result = Math.min(result, bucketLazyUpdate[k]);
				}
				else {
					for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
						result = Math.min(result, data[i]);
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