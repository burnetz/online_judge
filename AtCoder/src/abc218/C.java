package abc218;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] matrixS = new char[n][n];
		char[][][] matrixT = new char[4][n][n];

		for(int i = 0; i < n; i++){
			matrixS[i] = sc.next().toCharArray();
		}

		for(int i = 0; i < n; i++){
			matrixT[0][i] = sc.next().toCharArray();
		}

		int black1 = 0, black2 = 0;

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrixS[i][j] == '#'){
					black1++;
				}
				if(matrixT[0][i][j] == '#'){
					black2++;
				}
			}
		}

		//#の個数が合っていなければ論外
		if(black1 != black2){
			System.out.println("No");
			return;
		}

		//Tを90度ずつ回転させた図形を作る
		for(int k = 1; k < 4; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					matrixT[k][n - j - 1][i] = matrixT[k - 1][i][j];
				}
			}
		}

		int x1 = 0, y1 = 0;

		//Sの一番最初の#の座標を取得
loop1:		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrixS[i][j] == '#'){
					x1 = j;
					y1 = i;
					break loop1;
				}
			}
		}

		boolean success;
		for(int i = 0; i < 4; i++){
			int x2 = 0, y2 = 0;

			//Tの一番最初の#の座標を取得
			loop2: for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					if(matrixT[i][j][k] == '#'){
						x2 = k;
						y2 = j;
						break loop2;
					}
				}
			}

			//平行移動の距離が一意に定まる
			//なお厳密にはこの方法だとTのオフセット込みN*Nの範囲外に#が存在することがありえるが
			//それは序盤の#の個数チェックで弾くことができる。
			int offsetX = x2 - x1;
			int offsetY = y2 - y1;

			success = true;
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					int j2 = j + offsetY;
					int k2 = k + offsetX;

					//Sのあるマスが#の場合、Tの当該マスが.のときはもちろん範囲外のときも#ではないのでアウト
					if(matrixS[j][k] == '#' && (!inRange(j2, n) || !inRange(k2, n) || matrixT[i][j2][k2] == '.')){
						success = false;
						break;
					}

					//一方こちらでは範囲外は.とみなせるため上とは条件が異なる。
					if(matrixS[j][k] == '.' && inRange(j2, n) && inRange(k2, n) && matrixT[i][j2][k2] == '#'){
						success = false;
						break;
					}
				}
				if(!success){
					break;
				}
			}
			if(success){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

	static boolean inRange(int x, int n){
		if(x < 0 || x >= n){
			return false;
		}
		else{
			return true;
		}
	}
}
