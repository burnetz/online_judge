package dataSet;

import java.util.Arrays;
import java.util.Scanner;

//AOJ DSL_2_Dで動作確認済
public class RangeUpdateQuery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();

		SqrtDecomposition sq = new SqrtDecomposition(n);
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
				int index = sc.nextInt();

				System.out.println(sq.get(index));
			}

		}
	}

}

class SqrtDecomposition {
	int N, K;
	long[] data;
	long[] bucketLazyUpdate;
	static final int sqrtN = 512;
	static final int NIL = Integer.MIN_VALUE;

	public SqrtDecomposition(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketLazyUpdate = new long[K];
		Arrays.fill(bucketLazyUpdate, NIL);
	}

	// [s, t)
	void update(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketLazyUpdate[k] = x;
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
			}
		}
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