package abc176;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int ch = sc.nextInt() - 1;
		int cw = sc.nextInt() - 1;
		int dh = sc.nextInt() - 1;
		int dw = sc.nextInt() - 1;

		char[][] board = new char[h][w];
		int [][] group = new int[h][w];

		for(int i = 0; i < h; i++){
			board[i] = sc.next().toCharArray();
		}

		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int currentGid = 1;
		//BFSで全ての歩けるマスにグループIDを設定する
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(board[i][j] == '#'){
					continue;
				}

				if(group[i][j] == 0){
					ArrayDeque<Point> queue = new ArrayDeque<Point>();

					group[i][j] = currentGid;
					queue.add(new Point(j, i));

					while(!queue.isEmpty()){
						Point tmp = queue.removeFirst();
						for(int k = 0; k < 4; k++){
							int tmpX = tmp.x + dx[k];
							int tmpY = tmp.y + dy[k];

							if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h &&
									board[tmpY][tmpX] == '.' && group[tmpY][tmpX] == 0){
								group[tmpY][tmpX] = currentGid;
								queue.add(new Point(tmpX, tmpY));
							}
						}

					}

					currentGid++;
				}
			}
		}

		if(group[ch][cw] == group[dh][dw]){
			System.out.println(0);
			return;
		}

		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[currentGid + 1];

		for(int i = 0; i < edges.length; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}

		//あるグループから他のグループへのワープを辺として
		//ダイクストラで最短距離を求める。
		//全く同じ辺は無駄なので既出かどうかをsetで管理する
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(board[i][j] == '#'){
					continue;
				}
				for(int k = -2; k <= 2; k++){
					for(int l = -2; l <= 2; l++){
						int tmpX = j + l;
						int tmpY = i + k;

						if(tmpX < 0 || tmpX >= w || tmpY < 0 || tmpY >= h || board[tmpY][tmpX] == '#'){
							continue;
						}

						int group1 = group[i][j];
						int group2 = group[tmpY][tmpX];

						if(group1 == group2){
							continue;
						}
						String tmpStr = group1 + " " + group2;
						String tmpStr2 = group2 + " " + group1;

						if(!set.contains(tmpStr)){
							set.add(tmpStr);

							edges[group1].add(new Edge(group2, 1));

						}
						if(!set.contains(tmpStr2)){
							set.add(tmpStr2);

							edges[group2].add(new Edge(group1, 1));

						}
					}
				}
			}
		}

		int[] result = dijkstra(edges, group[ch][cw], currentGid);

		System.out.println(result[group[dh][dw]] != INF ? result[group[dh][dw]] : -1);

	}

	static final int INF = Integer.MAX_VALUE;

	//ダイクストラ法
	static int[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

		PriorityQueue<Distance> que = new PriorityQueue<Distance>();
		int[] dist = new int[n];

		Arrays.fill(dist, INF);
		dist[s] = 0;
		que.add(new Distance(0, s));

		while(!que.isEmpty()){
			Distance tmpDist = que.poll();
			int tmpV = tmpDist.id;

			if(dist[tmpV] < tmpDist.dist){
				continue;
			}
			for(int i = 0; i < edges[tmpV].size() ; i++){
				Edge e = (Edge) edges[tmpV].get(i);
				if(dist[e.to] > dist[tmpV] + e.cost){
					dist[e.to] = dist[tmpV] + e.cost;
					que.add(new Distance(dist[e.to], e.to));
				}
			}
		}

		return dist;
	}
}

class Distance implements Comparable<Distance>{
	int dist;
	int id;

	Distance(int dist, int id){
		this.dist = dist;
		this.id = id;
	}

	@Override
	public int compareTo(Distance d) {
		return this.dist - d.dist;
	}
}

class Edge {
	int to;
	int cost;

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}

class Point{
	int x;
	int y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}