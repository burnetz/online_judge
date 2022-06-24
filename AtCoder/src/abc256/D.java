package abc256;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int limit = 2_00002;
		
		//使われる数字の上限が200000までなのでRUQを使えば特に問題なく管理できる
		SqrtDecomposition sd = new SqrtDecomposition(limit);
		
		for(int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			sd.update(l, r, 1);
		}
		
		int left = 1;
		
		for(; left < limit - 2; ) {
			while(sd.get(left) == 0) {
				left++;
				if(left >= limit - 1) {
					return;
				}
			}
			
			int right = left + 1;
			
			while(sd.get(right) == 1) {
				right++;
			}
			
			System.out.println(left + " " + right);
			left = right + 1;
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