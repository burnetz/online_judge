package abc270;

import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long a[] = new long[n];
		long k = sc.nextLong();
		
		//中に1個以上入っているかごを入れておく
		PriorityQueue<Box> pq = new PriorityQueue<Box>();
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			
			if(a[i] >= 1) {
				pq.add(new Box(i, a[i]));
			}
		}
		
		//1個ずつ消費していたら間に合わないので十分に多いうちは数周分ずつまとめて消費させる。
		//その際にかごの中身にアクセスするとまとめて計算しても間に合わないのでオフセットを利用する。
		//中身のあるかごの数そのものが毎回変わるのでキューのサイズを利用する。
		long offset = 0;
		while(!pq.isEmpty()) {
			if(pq.size() > k) {
				break;
			}
			//1周ずつでは間に合わないので何周ならまとめて処理できるかを考える。
			long minimum = Math.min(k/pq.size(), pq.peek().amount - offset);
			k -= minimum*pq.size();
			//オフセットと一致したということはかごに1つも入っていないということ。
			while(pq.peek().amount == offset) {
				pq.remove();
			}
			offset += minimum;
		}
		
		for(int i = 0; i < n ; i++) {
			//オフセットより大きいということは最後の周で1以上余っているということ
			if(a[i] > offset) {
				if(k > 0) {
					a[i] = a[i] - offset - 1;
					k--;
				}
				else {
					a[i] -= offset;
				}
			}
			//オフセット以下なら必ず0個
			else {
				a[i] = 0;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

class Box implements Comparable<Box>{
	int id;
	long amount;
	
	Box (int id, long amount){
		this.id = id;
		this.amount = amount;
	}

	@Override
	public int compareTo(Box b) {
		// TODO Auto-generated method stub
		return this.amount == b.amount ? 0 : 
			this.amount > b.amount ? 1 : -1;
	}
}