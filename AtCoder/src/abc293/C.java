package abc293;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int matrix[][] = new int[h][w];
		history = new int[h + w];
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(dfs(0, 0, h, w, matrix));
	}
	
	static int history[];
	static long dfs (int x, int y, int h, int w, int[][] matrix) {
		//どちらに進むとしても1マスずつゴールに近づくのでこの方法で記録できる。
		history[x + y] = matrix[y][x];
		
		//ゴールに到達してから数字の重複をチェックする。
		if(x == w - 1 && y == h - 1) {
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i = 0; i < history.length; i++) {
				if(set.contains(history[i])) {
					return 0;
				}
				set.add(history[i]);
			}
			return 1;
		}
		
		long result = 0;
		if(x < w - 1) {
			result += dfs(x + 1, y, h, w, matrix);
		}
		
		if(y < h - 1) {
			result += dfs(x, y + 1, h, w, matrix);
		}
		
		return result;
	}
}