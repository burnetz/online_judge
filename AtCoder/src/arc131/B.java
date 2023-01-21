package arc131;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(matrix[i][j] != '.') {
					continue;
				}
				boolean[] used = new boolean[6];
				
				for(int k = 0; k < 4; k++) {
					int tmpX = j + dx[k];
					int tmpY = i + dy[k];
					
					if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] != '.') {
						used[matrix[tmpY][tmpX] - '0'] = true; 
					}
				}
				
				for(int k = 1; k <= 5; k++) {
					if(!used[k]) {
						matrix[i][j] = (char)(k + '0');
						break;
					}
				}
				
			}
		}
		for(int i = 0; i < h; i++) {
			System.out.println(matrix[i]);
		}
	}
}