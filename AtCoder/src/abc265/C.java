package abc265;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][];
		
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		boolean[][] visit = new boolean[h][w];
		
		int x = 0;
		int y = 0;
		while(true) {
			int tmpX = x;
			int tmpY = y;

			switch (matrix[y][x]) {
			case 'U': {
				tmpY--;
				break;
			}
			case 'D': {
				tmpY++;
				break;
			}
			case 'R': {
				tmpX++;
				break;
			}
			case 'L': {
				tmpX--;
				break;
			}
			}
			
			if(tmpX < 0 || tmpX >= w || tmpY < 0 || tmpY >= h) {
				System.out.println(y + 1  + " " + (x + 1));
				return;
			}
			
			if(visit[tmpY][tmpX]) {
				System.out.println(-1);
				return;
			}
			
			x = tmpX;
			y = tmpY;
			visit[y][x] = true;
		}
	}
	
}