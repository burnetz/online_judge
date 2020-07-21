package dataSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//AOJ DSL_2_Gで動作確認済
public class RSQandRAQ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int q = Integer.parseInt(tmpArray[1]);

		SqrtDecompositionRSQRAQ sq = new SqrtDecompositionRSQRAQ(n);

		for(int i = 0; i < q ; i++){
			tmpArray = br.readLine().split(" ");
			if(tmpArray[0].equals("0")){
				sq.add(Integer.parseInt(tmpArray[1]), Integer.parseInt(tmpArray[2]) + 1, Integer.parseInt(tmpArray[3]));
			}

			else {
				System.out.println(sq.getSum(Integer.parseInt(tmpArray[1]), Integer.parseInt(tmpArray[2]) + 1));
			}
		}
	}

}

class SqrtDecompositionRSQRAQ {
	int N, K;
	long[] data;
	long[] bucketAdd;
	long[] bucketSum;
	static final int sqrtN = 512;

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