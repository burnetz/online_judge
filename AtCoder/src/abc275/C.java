package abc275;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[][] matrix = new char[9][9];
		
		for(int i = 0; i < 9; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		int result = 0;
		//盤面が小さいのでループが深くなっても十分間に合う
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(matrix[i][j] == '.') {
					continue;
				}
				
				for(int k = 0; k < 9; k++) {
					for(int l = 0; l < 9; l++) {
						if(matrix[k][l] == '.') {
							continue;
						}
						
						//2点間のベクトルを作り、これを回転させることで他の頂点に移る
						int dx = l - j;
						int dy = k - i;
						
						if(dx == 0 && dy == 0) {
							continue;
						}
						int currentX = l;
						int currentY = k;
						
						//ベクトルを作った時点で2点は結ばれているので
						//残り2点が存在すればOK
						//ただし半時計回りだけを考える
						for(int m = 0; m < 2; m++) {
							int tmpdx = -dy;
							int tmpdy = dx;
							dx = tmpdx;
							dy = tmpdy;
							
							currentX += dx;
							currentY += dy;
							
							if(!inRange(currentX, currentY) || matrix[currentY][currentX] == '.') {
								break;
							}
							
							if(m == 1) {
								result++;
							}
						}
					}
				}
				
			}
		}
		//半時計回りに制限しても4倍のダブリが発生する
		System.out.println(result/4);
	}
	
	static boolean inRange(int x, int y) {
		if(x >= 0 && x < 9 && y >= 0 && y < 9) {
			return true;
		}
		else {
			return false;
		}
	}
}

