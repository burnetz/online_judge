package abc198;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] colors = new int[n];
		for(int i = 0; i < n; i++) {
			colors[i] = sc.nextInt();
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lists = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		visited = new boolean[n];
		pq = new PriorityQueue<Integer>();
		int colorTmp[] = new int[100000 + 1];
		solve(0, lists, colors, colorTmp);

		while (!pq.isEmpty()) {
			System.out.println(pq.remove() + 1);
		}
	}
	
	static boolean visited[];
	static PriorityQueue<Integer> pq;
	//木構造なのでノード間の最短経路は1パターンしか存在しない。
	//そのため途中で出てきた色の情報を保存しておけばDFSで判断することが可能。
	//最悪の場合の深さがによるスタックオーバーフローが心配だったがこれでも通る。
	static void solve(int node, ArrayList<Integer>[] lists, int[] colors, int colorTmp[]) {
		visited[node] = true;
		colorTmp[colors[node]]++;
		
		if(colorTmp[colors[node]] == 1) {
			pq.add(node);
		}
		
		for(int i = 0; i < lists[node].size(); i++) {
			int tmpV = lists[node].get(i);
			
			if(!visited[tmpV]) {
				solve(tmpV, lists, colors, colorTmp);
			}
		}
		
		colorTmp[colors[node]]--;
	}

}
