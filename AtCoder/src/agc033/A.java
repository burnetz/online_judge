package agc033;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int dist[][] = new int[h][w];
		boolean visit[][] = new boolean[h][w];

		//初期状態で黒の座標を全てキューに入れてBFSを行う
		//O(HW)なので十分間に合う
		char[][] board = new char[h][w];
		Deque<Point> queue = new ArrayDeque<Point>();
		for(int i = 0; i < h; i++){
			char[] input = sc.next().toCharArray();
			for(int j = 0; j < w; j++){
				board[i][j] = input[j];

				if(input[j] == '#'){
					queue.add(new Point(j, i));
					visit[i][j] = true;
					dist[i][j] = 0;
				}
			}
		}

		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		while(!queue.isEmpty()){
			Point p = queue.removeFirst();

			for(int i = 0; i < 4; i++){
				int tmpX = p.x + dx[i];
				int tmpY = p.y + dy[i];

				if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && !visit[tmpY][tmpX]){
					visit[tmpY][tmpX] = true;
					dist[tmpY][tmpX] = dist[p.y][p.x] + 1;
					queue.add(new Point(tmpX, tmpY));
				}
			}
		}

		int result = 0;

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				result = Math.max(result, dist[i][j]);
			}
		}

		System.out.println(result);

	}
}

class Point {
	int x, y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}