package abc272;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Vector<Integer> vecX = new Vector<Integer>();
		Vector<Integer> vecY = new Vector<Integer>();
		
		//距離がMとなるベクトルを事前に作っておく。
		//座標を整数に限定すればそこまで多くはない。
		for(int i = -1000; i <= 1000 ; i++) {
			for(int j = -1000; j <= 1000; j++) {
				int tmp = i*i + j*j;
				
				if(tmp == m) {
					vecX.add(i);
					vecY.add(j);
				}
			}
		}
		
		int matrix[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], -1);
		}
		
		ArrayDeque<Pair> que = new ArrayDeque<Pair>();
		matrix[0][0] = 0;
		que.add(new Pair(0, 0));
		
		//聞かれているのが最短のターン数なのでBFSで解く
		while(!que.isEmpty()) {
			Pair v = que.remove();
			
			for(int i = 0; i < vecX.size(); i++) {
				int tmpX = v.x + vecX.get(i);
				int tmpY = v.y + vecY.get(i);
				
				if(tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= n) {
					continue;
				}
				
				if(matrix[tmpY][tmpX] == -1) {
					matrix[tmpY][tmpX] = matrix[v.y][v.x] + 1;
					que.add(new Pair(tmpX, tmpY));
				}
			}
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}