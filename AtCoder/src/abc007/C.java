package abc007;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
	static char[][] board;
	static int[][] dist;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();

		board = new char[r][c];
		dist = new int[r][c];
		visit = new boolean[r][c];

		int sy = sc.nextInt() - 1;
		int sx = sc.nextInt() - 1;
		int gy = sc.nextInt() - 1;
		int gx = sc.nextInt() - 1;

		for(int i = 0; i < r; i++){
			String tmp = sc.next();
			for(int j = 0; j < c; j++){
				board[i][j] = tmp.charAt(j);
			}
		}
		ArrayList<Point2D> queue = new ArrayList<Point2D>();

		visit[sy][sx] = true;
		dist[sy][sx] = 0;
		queue.add(new Point2D.Double(sx, sy));

		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		while(!queue.isEmpty()){
			Point2D point = queue.remove(0);

			for(int i = 0; i < 4; i++){
				int tmpX = (int)point.getX() + dx[i];
				int tmpY = (int)point.getY() + dy[i];

				if(tmpX < 0 || tmpX >= c || tmpY < 0 || tmpY >= r || board[tmpY][tmpX] == '#'){
					continue;
				}

				if(!visit[tmpY][tmpX]){
					visit[tmpY][tmpX] = true;
					dist[tmpY][tmpX] = dist[(int)point.getY()][(int)point.getX()] + 1;
					queue.add(new Point2D.Double(tmpX, tmpY));
				}
			}
		}

		System.out.println(dist[gy][gx]);

	}
}