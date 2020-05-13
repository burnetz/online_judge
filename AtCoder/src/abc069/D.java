package abc069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int h = Integer.parseInt(tmpArray[0]);
		int w = Integer.parseInt(tmpArray[1]);

		int[][] tile = new int[h][w];
		for(int i = 0; i < h; i++){
			Arrays.fill(tile[i], 0);
		}

		int n = Integer.parseInt(br.readLine());

		int[] color = new int[n];
		tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			color[i] = Integer.parseInt(tmpArray[i]);
		}

		final int RIGHT = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int UP = 3;
		int[] vx = {1,0,-1,0};
		int[] vy = {0,1,0,-1};
		int mode = RIGHT;
		int currentX = 0;
		int currentY = 0;

		for(int i = 1; i <= n; i++){
			for(int j = 0 ; j < color[i - 1] ; j++){
				//coloring
				tile[currentY][currentX] = i;
				if(mode == RIGHT && (currentX + 1 == w || tile[currentY][currentX + 1] != 0)){
					mode = DOWN;
				}
				else if(mode == DOWN && (currentY + 1 == h || tile[currentY + 1][currentX ] != 0)){
					mode = LEFT;
				}

				else if(mode == LEFT && (currentX == 0 || tile[currentY][currentX - 1] != 0)){
					mode = UP;
				}

				else if(mode == UP && (currentY == 0 || tile[currentY - 1][currentX] != 0)){
					mode = RIGHT;
				}

				currentX += vx[mode];
				currentY += vy[mode];


			}

		}

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(j == 0){
					System.out.print(tile[i][j]);
				}
				else {
					System.out.print(" "+tile[i][j]);
				}
			}
			System.out.println();
		}

	}

}