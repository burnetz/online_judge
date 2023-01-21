package abc179;

import java.util.Scanner;

public class D {

	static int mod = 998244353;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		Range[] ranges = new Range[k];
		for(int i = 0; i < k; i++){
			ranges[i] = new Range(sc.nextInt(), sc.nextInt());
		}

		SqrtDecompositionRSQRAQ sq = new SqrtDecompositionRSQRAQ(n + 1);
		sq.add(1, 2, 1);
		//素朴な解き方であればDPでO(N^2)になるが間に合わない。
		//区間自体は全部で10個しかないので区間クエリを効率よく扱えるなら間に合う
		for(int i = 2; i <= n; i++){
			long tmpSum = 0;
			for(int j = 0; j < k; j++){
				int tmpStart = Math.max(i - ranges[j].end, 0);
				int tmpEnd = i - ranges[j].start;

				if(tmpEnd < 0){
					continue;
				}

				tmpSum += sq.getSum(tmpStart, tmpEnd + 1);
				tmpSum %= mod;

			}

			sq.add(i, i + 1, (int)tmpSum);
		}

		System.out.println(sq.getSum(n, n + 1));
	}
}

class Range {
	int start;
	int end;

	Range(int s, int e){
		this.start = s;
		this.end = e;
	}
}

class SqrtDecompositionRSQRAQ {
	int N, K;
	long[] data;
	long[] bucketAdd;
	long[] bucketSum;
	static final int sqrtN = 512;

	public void print(){
		for(int i = 0; i < N; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public SqrtDecompositionRSQRAQ(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketAdd = new long[K];
		bucketSum = new long[K];
	}

	void add(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketAdd[k] += x;
			} else {
				for(int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					data[i] += x;
				}
				bucketSum[k] = 0;
				for(int i = l; i < r; i++){
					bucketSum[k] += data[i];
				}
			}
		}
	}

	long getSum(int s, int t){
		long result = 0;
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				result += bucketAdd[k]*sqrtN + bucketSum[k];
			} else {
				int count = 0;
				for(int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					result += data[i];
					count++;
				}

				result += bucketAdd[k]*count;
			}
		}
		return result;
	}
}