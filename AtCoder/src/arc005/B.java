package arc005;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		String w = sc.next();

		int c[][] = new int[9][9];
		for(int i = 0; i < 9; i++){
			String str = sc.next();
//			System.out.println(str);
			for(int j = 0; j < 9; j++){
				c[i][j] = str.charAt(j) - '0';
			}
		}

		String[] modeList = {"R", "L", "U", "D", "RU", "RD", "LU", "LD"};
		int dxList[] = {1,-1,0,0,1,1,-1,-1};
		int dyList[] = {0,0,-1,1,-1,1,-1,1};

		int dx = 0;
		int dy = 0;
		for(int i = 0; i < modeList.length; i++){
			if(modeList[i].equals(w)){
				dx = dxList[i];
				dy = dyList[i];
				break;
			}
		}

		String result = "";
		for(int i = 0; i < 4; i++){
			result += c[y][x];

			int tmpX = 0;
			int tmpY = 0;

			//最大2回で抜けられる
			while(true){
				tmpX = x + dx;
				tmpY = y + dy;

				if(tmpX < 0 || tmpX >= 9){
					dx *= -1;
					continue;
				}
				if(tmpY < 0 || tmpY >= 9){
					dy *= -1;
					continue;
				}

				break;
			}
			x = tmpX;
			y = tmpY;
		}

		System.out.println(result);
	}
}