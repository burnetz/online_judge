package arc138;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Pair[] pairs = new Pair[n];
		
		for(int i = 0; i < n; i++) {
			pairs[i] = new Pair(sc.nextInt(), i);
		}
		//まずは値について昇順、値が同じならインデックスについて降順に並べる。
		//値を交換するときに同じ値ならなるべくインデックスが大きい方を追い出したほうが良いため
		Arrays.sort(pairs);
		
		//今まで見た中でk未満の最大のインデックス
		int maxIndex = -1;
		int result = Integer.MAX_VALUE;
		//ある2つの数字のペアを交換することだけを考えるのが最適（区間内で余計なことをしない）
		//なので条件を満たすペアの中で区間長が最小のものを探す
		for(int i = 0; i < n; i++) {
			if(i >= 1 && maxIndex >= 0 && pairs[i].index >= k) {
				result = Math.min(result, pairs[i].index - maxIndex);
			}
			if(pairs[i].index < k) {
				maxIndex = Math.max(maxIndex, pairs[i].index);
			}
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
}

class Pair implements Comparable<Pair>{
	int value;
	int index;
	
	Pair(int value, int index){
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Pair p) {
		// TODO Auto-generated method stub
		return this.value != p.value ? this.value - p.value : 
			p.index - this.index;
	}
	
	
}