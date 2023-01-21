package abc276;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		matrix = new char[h][];
		visit = new boolean[h][w];
		
		int startX = 0;
		int startY = 0;
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
			for(int j = 0; j < w; j++) {
				if(matrix[i][j] == 'S') {
					startX = j;
					startY = i;
				}
			}
		}
		
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};

		//DFSで解きたいがスタートとゴールが同じマスなので
		//あえてスタートから1マスずらしたところからゴールを目指す。
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < h; j++) {
				Arrays.fill(visit[j], false);
			}
			
			//多分再帰で書くとスタックオーバーフローを起こすので
			//スタックを使ったDFSを実装する。
			Stack<State> stack = new Stack<State>();
			int startX1 = startX + dx[i];
			int startY1 = startY + dy[i];
			
			if(!inRange(startX1, startY1, h, w) || matrix[startY1][startX1] == '#') {
				continue;
			}
			visit[startY1][startX1] = true;
			
			stack.add(new State(startX1, startY1, 1));
			
			
			while(!stack.isEmpty()) {
				State tmpState = stack.pop();
				for(int j = 0; j < 4; j++) {
					int x1 = tmpState.x + dx[j];
					int y1 = tmpState.y + dy[j];
					
					if(!inRange(x1, y1, h, w) || matrix[y1][x1] == '#') {
						continue;
					}
					
					if(x1 == startX && y1 == startY) {
						if(tmpState.dist >= 3) {
							System.out.println("Yes");
							return;
						}
						//初手逆進の対策
						else {
							continue;
						}
					}
					
					if(!visit[y1][x1]) {
						visit[y1][x1] = true;
						stack.add(new State(x1, y1, tmpState.dist + 1));
						
					}
				}
			}
		}		
		System.out.println("No");
	}
	
	static char[][] matrix;
	static boolean[][] visit;
	
	static boolean inRange(int x, int y, int h, int w) {
		if(x >= 0 && x < w && y >= 0 && y < h) {
			return true;
		}
		else {
			return false;
		}
	}
}

class State {
	int x;
	int y;
	int dist;
	
	State(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}