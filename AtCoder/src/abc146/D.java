package abc146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] tmpArray;
		Node nodes[] = new Node[n];
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}
		
		Edge[] edges = new Edge[n - 1];
		for(int i = 0; i < n - 1; i++) {
			tmpArray = br.readLine().split(" ");
			int start = Integer.parseInt(tmpArray[0]) - 1;
			int end = Integer.parseInt(tmpArray[1]) - 1;
			
			edges[i] = new Edge(start, end);
			
			nodes[start].edges.add(edges[i]);
			nodes[end].edges.add(edges[i]);
		}
	
		int maxIndex = 0;
		int maxColors = 0;
		
		for(int i = 0; i < n; i++) {
			if(maxColors < nodes[i].edges.size()) {
				maxColors = nodes[i].edges.size();
				maxIndex = i;
			}
		}
		
		System.out.println(maxColors);
		
		//BFS
		//一番接続数の多い頂点をrootとして色を決めていく
		//それぞれの頂点で、使える色からできるだけ小さい数字を順に使えばよい
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(nodes[maxIndex]);
		nodes[maxIndex].visit = true;
		
		while(!queue.isEmpty()) {
			Node v = queue.remove(0);
			
			//coloring
			int prevColor = 0;
			for(int i = 0; i < v.edges.size(); i++) {
				Edge target = v.edges.get(i);
				
				//辺に色がついていない場合
				if(target.color == -1) {
					//使える色を順に探す
					for(int j = prevColor + 1; j <= maxColors; j++) {
						if(!v.usedColors.contains(j)) {
							target.color = j;
							//移動先の頂点に使用済みの色情報を保存
							nodes[target.start].usedColors.add(j);
							nodes[target.end].usedColors.add(j);
							prevColor = j;
							break;
						}
					}
				}
				//startとendのうち片方は親だが訪問済みになっているはずなので問題ない
				if(!nodes[target.start].visit) {
					nodes[target.start].visit = true;
					queue.add(nodes[target.start]);
				}
				if(!nodes[target.end].visit) {
					nodes[target.end].visit = true;
					queue.add(nodes[target.end]);
				}

			}
			
			
		}
		
		for(int i = 0; i < n - 1; i++) {
			System.out.println(edges[i].color);
		}
	}

}

class Node {
	Vector<Edge> edges = new Vector<Edge>();
	boolean visit = false;
	//接している辺で何色を使ったかを記憶
	HashSet<Integer> usedColors = new HashSet<Integer>();

}
class Edge {
	int start;
	int end;
	int color;
	
	Edge(int start, int end){
		this.start = start;
		this.end = end;
		this.color = -1;
	}
}