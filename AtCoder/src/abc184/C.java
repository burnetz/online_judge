package abc184;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long r1 = sc.nextInt();
		long c1 = sc.nextInt();
		long r2 = sc.nextInt();
		long c2 = sc.nextInt();
		
		long dr = r2 - r1;
		long dc = c2 - c1;

		//最悪でも3ターンでどこにでも行ける。
		//それより短いパターンを全網羅する。
		int result = 3;
		//同じ座標なら移動不要
		if(dr == 0 && dc == 0) {
			result = 0;
		}
		//初期位置から45度系は1ターン
		else if(Math.abs(dr) == Math.abs(dc)) {
			result = 1;
		}
		//初期位置からのマンハッタン距離が3以下なら1ターン
		else if(Math.abs(dr) + Math.abs(dc) <= 3) {
			result = 1;
		}
		//初期位置からのマンハッタン距離が6以下なら2ターン
		else if(Math.abs(dr) + Math.abs(dc) <= 6) {
			result = 2;
		}
		//チェスで言う黒白が初期位置と同じなら2ターン
		//距離に関係なく成り立つので最悪3ターンと言い切れる
		else if((r1 + c1)%2 == (r2 + c2)%2) {
			result = 2;
		}
		else {
			//初期位置からずらせば斜め移動1回で到達できるのなら2ターン
			//初期位置からループで縦横にずらして試す
			for(int i = -3; i <= 3; i++) {
				dr = r2 - (r1 + i);
				dc = c2 - c1;
				if(Math.abs(dr) == Math.abs(dc)) {
					result = 2;
					break;
				}
			}
			for(int i = -3; i <= 3; i++) {
				dr = r2 - r1;
				dc = c2 - (c1 + i);
				if(Math.abs(dr) == Math.abs(dc)) {
					result = 2;
					break;
				}
			}
		}
		System.out.println(result);
	}

}
