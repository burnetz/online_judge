package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class TopologicalSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//各頂点に入る辺の本数を記録する
		int inNum[] = new int[n];

		//入力をグラフとみなす
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lists = new ArrayList[n];

		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			//同じ辺が複数ある場合もあるが問題なく動く
			inNum[b]++;
			lists[a].add(b);
		}

		//辞書順に出力する必要があるときは
		//入次数0の頂点を優先度付きキューで管理する。
		//順番を問わないなら普通のキューを使ったほうが速い。
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Vector<Integer> result = new Vector<Integer>();

		//まずは入次数0の頂点を全てキューに入れる
		for(int i = 0; i < n; i++) {
			if(inNum[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int v = pq.remove();

			result.add(v);
			//vから出る辺を全て削除（本当に消す必要はない。本数情報だけ更新する）
			for(int i = 0; i < lists[v].size(); i++) {
				int to = lists[v].get(i);

				inNum[to]--;

				if(inNum[to] == 0) {
					pq.add(to);
				}
			}
		}

		//こちらの分岐では余っている頂点がある。
		//つまりサイクルが残っているため条件を満たせない。
		if(result.size() != n) {
			System.out.println(-1);
		}
		else {
			for(int i = 0; i < n; i++) {
				System.out.println(result.get(i));
			}
		}
	}

}
