package arc040;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		char[] s = sc.next().toCharArray();
		
		int time = 0;
		
		//自分が右端に行く必要はないので
		//どこからなら一番右にある空白を塗れるかを計算する
		int right = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(s[i] == '.') {
				right = Math.max(0, i - r + 1);
				break;
			}
		}
		
		for(int i = right; i >= 0; i--) {
			//塗る必要がある場合（射程ギリギリのマスだけ見ている）
			if(s[i + r - 1] == '.') {
				for(int j = i; j < i + r; j++) {
					s[j] = 'o';
				}
				time++;
			}
			
			//トドメが必要か確認（スタート付近は上記の分岐に引っかからないため）
			if(i == 0) {
				int blank = 0;
				for(int j = 0; j < r; j++) {
					if(s[j] == '.') {
						blank++;
					}
				}
				
				//トドメが不要なら何もしない（必要ならブロック外のインクリメントで塗りの時間消費）
				if(blank == 0) {
					break;
				}
			}

			//歩いたことによる時間経過
			time++;
		}
		
		System.out.println(time);
	}
}

