package abc239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		nodes = new NodeE[n];
		edges = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new NodeE(i, sc.nextInt());
			edges[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add(new Edge(b));
			edges[b].add(new Edge(a));
		}
		
		dfs(0);
		
		//ここまでで既に各節点が上位20を保持しているので
		//各クエリに対してはO(1)で答えられる
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < q; i++) {
			int v = sc.nextInt() - 1;
			int k = sc.nextInt() - 1;
			
			sb.append(nodes[v].upper[k] + "\n");
		}
		System.out.print(sb);
	}

	static NodeE[] nodes;
	static ArrayList<Edge>[] edges;
	
	//木の構築と計算を同時にDFSで処理できる
	static void dfs(int id) {
		//この中に子の部分木の値をたくさん入れて上位20個だけ取り出すと配列ができる。
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		pq.add(nodes[id].value);
		for(int i = 0; i < edges[id].size(); i++) {
			NodeE target = nodes[edges[id].get(i).to];
			//逆流防止のための条件文
			if(target != nodes[id].parent) {
				nodes[id].children.add(target);
				target.parent = nodes[id];
				
				dfs(nodes[id].children.getLast().id);
				int tmpArray[] = nodes[id].children.getLast().upper;
				
				//1節点あたり上位20までしかデータを持っていないので全部pqに入れても間に合う
				for(int j = 0; j < tmpArray.length; j++) {
					pq.add(tmpArray[j]);
				}
			}
		}
		
		//上位20までをpqから配列に移し替える
		for(int i = 0; i < nodes[id].upper.length && !pq.isEmpty() ; i++) {
			nodes[id].upper[i] = pq.remove();
		}
	}

}

//各ノードが自分を根とする部分木内の上位20の値を保持する
class NodeE {
	int id;
	int value;
	NodeE parent = null;
	ArrayDeque<NodeE> children = new ArrayDeque<NodeE>();
	int upper[] = new int[20];
	
	NodeE(int id, int value){
		this.id = id;
		this.value = value;
	}
}

class Edge {
	int to;
	
	Edge(int to){
		this.to = to;
	}
}
