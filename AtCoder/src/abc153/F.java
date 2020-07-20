package abc153;

import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long d = sc.nextInt();
		long a = sc.nextInt();

		Fox foxes[] = new Fox[n];
		for(int i = 0; i < n; i++){
			foxes[i] = new Fox(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(foxes);

		SqrtDecomposition sq = new SqrtDecomposition(n);

		for(int i = 0; i < n; i++){
			sq.add(i + 1, i + 2, foxes[i].hp);
		}

		long count = 0;
		int j = 1;
		//基本的には左から順番にHP0になるまで攻撃すればよい。
		//ただし範囲全体に毎回ループでダメージ計算を行う時間はないので
		//範囲への減算のために平方分割をするなどの工夫が必要
		for(int i = 0; i < n; i++){
			if(sq.get(i + 1) <= 0){
				continue;
			}
			while(j < n && foxes[j].pos <= foxes[i].pos + 2*d){
				j++;
			}

			long tmpNum = (sq.get(i + 1) + a - 1)/a;
			count += tmpNum;
			sq.add(i + 1, j + 1, -a*tmpNum);
		}

		System.out.println(count);
	}

}


class SqrtDecomposition {
	int N, K;
	long[] data;
	long[] bucketAdd;
	static final int sqrtN = 512;

	public SqrtDecomposition(int n) {
		N = n;
		K = (N + sqrtN - 1) / sqrtN;
		data = new long[K * sqrtN];
		bucketAdd = new long[K];
	}

	void add(int s, int t, long x) {
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

class Fox implements Comparable<Fox> {
	long pos;
	long hp;

	Fox(int pos, int hp){
		this.pos = pos;
		this.hp = hp;
	}

	@Override
	public int compareTo(Fox f) {
		// TODO 自動生成されたメソッド・スタブ
		return (int)(this.pos - f.pos);
	}
}