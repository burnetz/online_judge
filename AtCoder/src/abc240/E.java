package abc240;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class E {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		nodes = new NodeE[n];
		edges = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new NodeE(i);
			edges[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add(new Edge(b));
			edges[b].add(new Edge(a));
		}
		
		dfs(0, 1);
		
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sb.append(nodes[i].range.from + " " + nodes[i].range.to + "\n");
		}
		System.out.print(sb);
	}

	static NodeE[] nodes;
	static ArrayList<Edge>[] edges;
	
	
	//それぞれの節点における区間の長さは葉の数と一致する。
	//それを1から始めて隙間なく敷き詰めるように範囲を決める。
	//DFSで木の構築と同時に区間を求めることができる
	static void dfs(int id, int left) {
		int tmpLeft = left;
		int tmpRight = left;
		for(int i = 0; i < edges[id].size(); i++) {
			NodeE target = nodes[edges[id].get(i).to];
			//逆流防止のための条件文
			if(target != nodes[id].parent) {
				nodes[id].children.add(target);
				target.parent = nodes[id];
				
				dfs(nodes[id].children.getLast().id, tmpLeft);
				//子の区間に応じて自分の区間の広さを更新する
				tmpRight = nodes[id].children.getLast().range.to;
				tmpLeft = nodes[id].children.getLast().range.to + 1;
			}
		}
		nodes[id].range = new Range(left, tmpRight);
	}

}

class NodeE {
	int id;
	NodeE parent = null;
	//常に一番右の子しか参照しないのでlistの必要はない
	ArrayDeque<NodeE> children = new ArrayDeque<NodeE>();
	Range range = null;
	
	NodeE(int id){
		this.id = id;
	}
}

class Edge {
	int to;
	
	Edge(int to){
		this.to = to;
	}
}

class Range {
	int from, to;
	
	Range(int from, int to){
		this.from = from;
		this.to = to;
	}
}