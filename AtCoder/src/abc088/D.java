package abc088;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		board = new char[h][w];
		dist = new int[h][w];
		visit = new boolean[h][w];

		int block = 0;
		for(int i = 0; i < h; i++){
			String str = sc.next();

			for(int j = 0; j < w; j++){
				board[i][j] = str.charAt(j);
				if(board[i][j] == '#'){
					block++;
				}
			}

		}


		//まずはBFSで最短距離を求める
		ArrayList<Point2D> queue = new ArrayList<Point2D>();

		visit[0][0] = true;
		dist[0][0] = 1;
		queue.add(new Point2D.Double(0, 0));

		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		while(!queue.isEmpty()){
			Point2D point = queue.remove(0);

			for(int i = 0; i < 4; i++){
				int tmpX = (int)point.getX() + dx[i];
				int tmpY = (int)point.getY() + dy[i];

				if(tmpX < 0 || tmpX >= w || tmpY < 0 || tmpY >= h || board[tmpY][tmpX] == '#'){
					continue;
				}

				if(!visit[tmpY][tmpX]){
					visit[tmpY][tmpX] = true;
					dist[tmpY][tmpX] = dist[(int)point.getY()][(int)point.getX()] + 1;
					queue.add(new Point2D.Double(tmpX, tmpY));
				}
			}
		}

		//ゴールに到達できるなら全マス - ブロック数 - 最短距離が答え
		System.out.println(dist[h - 1][w - 1] != 0 ? h*w - block - dist[h - 1][w - 1] : -1);

	}

	static char[][] board;
	static int[][] dist;
	static boolean[][] visit;

}
