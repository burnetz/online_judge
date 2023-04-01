package abc291;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//以下トポロジカルソートの実装
		//各頂点に入る辺の本数を記録する
		int inNum1[] = new int[n];

		//入力をグラフとみなす
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lists = new ArrayList[n];

		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		//トポロジカルソート自体は重複辺があっても可能だが
		//今回の問題では重複があると後述の判定が使えなくなるので排除する。
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			String tmpStr = a + "," + b;
			if(set.contains(tmpStr)) {
				continue;
			}
			inNum1[b]++;
			lists[a].add(b);
			set.add(tmpStr);
		}

		//入次数0の頂点をキューで管理する。
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		Vector<Integer> result1 = new Vector<Integer>();

		//まずは入次数0の頂点を全てキューに入れる
		for(int i = 0; i < n; i++) {
			if(inNum1[i] == 0) {
				pq1.add(i);
			}
		}
		while(!pq1.isEmpty()) {
			//順番が一意に定まるということはトポロジカルソートの結果が一意に定まるということ。
			//そのためには入次数0の点は常に高々1つである必要がある。
			if(pq1.size() >= 2) {
				System.out.println("No");
				return;
			}
			int v = pq1.remove();

			result1.add(v);
			//vから出る辺を全て削除（本当に消す必要はない。本数情報だけ更新する）
			for(int i = 0; i < lists[v].size(); i++) {
				int to = lists[v].get(i);

				inNum1[to]--;

				if(inNum1[to] == 0) {
					pq1.add(to);
				}
			}
		}

		//このまま出力しても正しい答えではないので適切に並び替える。
		int resultArray[] = new int[n];
		for(int i = 0; i < n; i++) {
			resultArray[result1.elementAt(i)] = i + 1;
		}

		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < n; i++) {
			sb.append(resultArray[i] + " ");			
		}
		System.out.println("Yes");
		System.out.println(sb);
	}
}

