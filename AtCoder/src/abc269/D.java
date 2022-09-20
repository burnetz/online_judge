package abc269;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			black[y + offset][x + offset] = true;
		}
		
		int id = 1;
		for(int i = 0; i < black.length; i++) {
			for(int j = 0; j < black.length; j++) {
				if(black[i][j] && gid[i][j] == 0) {
					dfs(j - offset, i - offset, id);
					id++;
				}
			}
		}
		
		System.out.println(id - 1);
	}
	//入力されうる値よりも少し大きめに確保することで範囲外のチェックを省略できる。
	static boolean black[][] = new boolean[1001*2 + 1][1001*2 + 1];
	static int offset = 1001;
	static int gid[][] = new int[1001*2 + 1][1001*2 + 1];
	
	static int dx[] = {-1, -1, 0, 0, 1, 1};
	static int dy[] = {-1, 0, -1, 1, 0, 1};
	
	//ハニカムでも通常の格子とやることは変わらない。
	//約2000*2000の範囲なのでDFSで探索可。
	static void dfs(int x, int y, int groupid) {
		gid[y + offset][x + offset] = groupid;
		
		for(int i = 0; i < 6; i++) {
			int tmpX = x + dx[i];
			int tmpY = y + dy[i];
			
			if(black[tmpY + offset][tmpX + offset] && gid[tmpY + offset][tmpX + offset] == 0) {
				dfs(tmpX, tmpY, groupid);
			}
		}
	}
}