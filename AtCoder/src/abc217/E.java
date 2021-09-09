package abc217;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		
		//ソートが発生すると言っても基本的には先頭しか気にしないので優先度付きキューでOK
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//直前のソート以後の要素はpqのあとにキューが続くと考える。
		//頻繁に先頭削除が発生するので多分ArrayListよりもDequeのほうが良い。
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();

			switch (mode) {
			case 1: 
				int x = sc.nextInt();
				deq.add(x);
				break;
			case 2:
				if(!pq.isEmpty()) {
					System.out.println(pq.remove());
				}
				//一度もソートが発生しなかった場合がこちらに該当する。
				else {
					System.out.println(deq.removeFirst());
				}
				break;
			default:
				//全体をソートするというのはdeqの中身をpqに流し込むということ。
				//先頭しか参照しないのでこれで十分
				while(!deq.isEmpty()) {
					pq.add(deq.removeFirst());
				}
			}
		}
	}

}
