package abc112;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] input = new int[n][3];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < 3; j++){
				input[i][j] = sc.nextInt();
			}
		}

		int centerX = 0;
		int centerY = 0;
		int centerH = 0;

		//全座標でシミュレートしてみる
loop1:		for(int x = 0; x <= 100; x++){
loop2:			for(int y = 0; y <= 100; y++){
				for(int i = 0; i < n; i++){
					//必ず一意に特定できるならどこか高さが0以上のところがあるはず
					//（高さ0が100個あったとしても特定できないため）
					//そこを基準に中心の高さを仮定する
					if(input[i][2] > 0){
						centerH = input[i][2] + Math.abs(input[i][0] - x) + Math.abs(input[i][1] - y);
						break;
					}
				}

				//仮定した高さとの矛盾をチェックする
				for(int i = 0; i < n; i++){
					if(input[i][2] != Math.max(centerH - Math.abs(input[i][0] - x) - Math.abs(input[i][1] - y), 0)){
						continue loop2;
					}
				}

				centerX = x;
				centerY = y;
				break loop1;
			}
		}

		System.out.println(centerX+ " " + centerY + " " + centerH);
	}
}
