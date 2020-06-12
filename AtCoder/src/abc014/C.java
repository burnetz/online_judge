package abc014;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		//平方分割などを使わないと間に合わない
		SqrtDecomposition sd = new SqrtDecomposition(1_000_001);

		for(int i = 0; i < n; i++){
			sd.add(sc.nextInt(), sc.nextInt() + 1, 1);
		}

		long result = 0;
		for(int i = 0; i <= 1_000_000; i++){
			result = Math.max(result, sd.get(i));
		}

		System.out.println(result);
	}

}

class SqrtDecomposition {
	int N, K;
	long[] data;
	long[] bucketAdd;
	static final int sqrtN = 1000;

	public SqrtDecomposition(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketAdd = new long[K];
	}

	void add(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketAdd[k] += x;
			} else {
				for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					data[i] += x;
				}
			}
		}
	}

	long get(int s) {
		int k = s / sqrtN;
		return data[s] + bucketAdd[k];
	}
}