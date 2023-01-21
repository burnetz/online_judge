package ddcc2020qual;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int k = sc.nextInt();
		
		char[][] input = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			input[i] = sc.next().toCharArray();
		}
		
		int matrix[][] = new int[h + 2][w + 2];
		int beginLine = Integer.MAX_VALUE;
		for(int i = 1; i <= h; i++) {
			boolean stb = false;
			
			//今の行にいちごが存在するかを調べる
			for(int j = 0; j < w; j++) {
				if(input[i - 1][j] == '#') {
					stb = true;
					beginLine = Math.min(beginLine, i);
					break;
				}
			}
			
			//いちごが1つも無いなら前の行をコピーすればよい
			if(!stb) {
				for(int j = 1; j <= w; j++) {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
			//いちごがあるならいちごを見たタイミングでグループ番号を切り替えればよい。
			//ただしその行で初めてのいちごであれば切り替えない。
			//（例えば1個しかなければ行全体が同じグループ番号で良い）
			else {
				int gid = matrix[i - 1][w] + 1;
				int stbCount = 0;
				
				for(int j = 1; j <= w; j++) {
					
					if(input[i - 1][j - 1] == '#') {
						stbCount++;
						
						if(stbCount >= 2) {
							gid++;
						}
					}
					matrix[i][j] = gid;
				}
			}
		}
		
		//上記の処理では最初の行にいちごが1個も無い場合に対応できない。
		//最初にいちごがあった行を上に向かってコピーする。
		for(int i = beginLine - 1; i >= 1; i--) {
			for(int j = 1; j <= w; j++) {
				matrix[i][j] = matrix[i + 1][j];
			}
		}
		
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= w; j++) {
				if(j != 1) {
					System.out.print(" ");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
