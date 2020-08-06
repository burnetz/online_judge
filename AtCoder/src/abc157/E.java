package abc157;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		int q = sc.nextInt();
		
		//登場する文字は全部で26種類なので
		//文字ごとに桁を決めればORで組み合わせを保存できる
		//ただし毎回ORを計算する時間はないので平方分割を使う
		SqrtDecompositionROQRUQ sq = new SqrtDecompositionROQRUQ(n);
		for(int i = 0; i < n; i++) {
			char c = str.charAt(i);
			sq.update(i, i + 1, 1 << (int)(c - 'a'));
		}
		
		for(int i = 0; i < q; i++) {
			int inst = sc.nextInt();
			
			if(inst == 1) {
				int index = sc.nextInt() - 1;
				char c = sc.next().charAt(0);
				sq.update(index, index + 1, 1 << (int)(c - 'a'));
			}
			else {
				int l = sc.nextInt() - 1;
				int r = sc.nextInt() - 1;
				
				long or = sq.getSum(l, r + 1);
				
				int count = 0;
				while(or > 0) {
					if(or%2 == 1) {
						count++;
					}
					or /= 2;
				}
				System.out.println(count);
			}
		}
	}
}

//区間アップデートだけでなくバケットごとにORを格納できるよう改造
class SqrtDecompositionROQRUQ {
	int N, K;
	long[] data;
	long[] bucketOr;
	long[] bucketLazyUpdate;
	static final int sqrtN = 512;
	static final int NIL = Integer.MIN_VALUE;

	public SqrtDecompositionROQRUQ(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketLazyUpdate = new long[K];
		Arrays.fill(bucketLazyUpdate, NIL);
		bucketOr = new long[K];
	}

	// [s, t)
	void update(int s, int t, int x) {
		for (int k = 0; k < K; ++k) {
			int l = k * sqrtN, r = (k + 1) * sqrtN;
			if (r <= s || t <= l)
				continue;
			if (s <= l && r <= t) {
				bucketLazyUpdate[k] = x;
				bucketOr[k] = x;
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
				bucketOr[k] = 0;
				for(int i = l; i < r; i++){
					bucketOr[k] |= data[i];
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
				result |= bucketOr[k];
			}
			else {
				for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
					if(bucketLazyUpdate[k] != NIL){
						result |= bucketLazyUpdate[k];
					}
					else {
						result |= data[i];
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