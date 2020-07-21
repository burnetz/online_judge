package dataSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//AOJ DSL_2_Hで動作確認済
public class RMQandRAQ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int q = Integer.parseInt(tmpArray[1]);

		SqrtDecompositionRMQRAQ sq = new SqrtDecompositionRMQRAQ(n);

		for(int i = 0; i < q ; i++){
			tmpArray = br.readLine().split(" ");
			if(tmpArray[0].equals("0")){
				sq.add(Integer.parseInt(tmpArray[1]), Integer.parseInt(tmpArray[2]) + 1, Integer.parseInt(tmpArray[3]));
			}

			else {
				System.out.println(sq.findMin(Integer.parseInt(tmpArray[1]), Integer.parseInt(tmpArray[2]) + 1));
			}
		}
	}

}

class SqrtDecompositionRMQRAQ {
	int N, K;
	long[] data;
	long[] bucketAdd;
	long[] bucketMin;
	static final int sqrtN = 512;

	public SqrtDecompositionRMQRAQ(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketAdd = new long[K];
		bucketMin = new long[K];
	}

	void add(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketAdd[k] += x;
				bucketMin[k] += x;
			} else {
				for(int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					data[i] += x;
				}
				bucketMin[k] = Integer.MAX_VALUE;
				for(int i = l; i < r; i++){
					bucketMin[k] = Math.min(bucketMin[k], data[i] + bucketAdd[k]);
				}
			}
		}
	}

	//[s,t)
	long findMin(int s, int t){
		long result = Integer.MAX_VALUE;
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {

				result = Math.min(result, bucketMin[k]);
			} else {

				for(int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					result = Math.min(result, data[i] + bucketAdd[k]);
				}
			}
		}
		return result;
	}
}