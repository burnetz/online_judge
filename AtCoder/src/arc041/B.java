package arc041;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int b[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				b[i][j] = str.charAt(j) - '0';
			}
		}
		
		int a[][] = new int[n][m];
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		//左上から順番に処理していけば多分一意に定まる
		for(int i = 1; i < n - 1; i++) {
			for(int j = 1; j < m - 1; j++) {
				int min = Integer.MAX_VALUE;
				//4方向の最小値をチェック
				for(int k = 0; k < 4; k++) {
					min = Math.min(min, b[i + dy[k]][j + dx[k]]);
				}
				
				a[i][j] += min;

				for(int k = 0; k < 4; k++) {
					b[i + dy[k]][j + dx[k]] -= min;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}

