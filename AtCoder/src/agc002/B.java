package agc002;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean red[] = new boolean[n + 1];
		red[1] = true;
		int ball[] = new int[n + 1];
		Arrays.fill(ball, 1);
		for(int i = 0 ; i < m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			//赤でも白でもボールの数自体は変わらないので普通に数えて良い
			ball[x]--;
			ball[y]++;

			//赤が入ってる可能性があるところから運べば移動先も赤の可能性が出てくる
			if(red[x]){
				red[y] = true;

				//ただし移動元が最初から1しかなかった場合、実際に取ったのが何かにかかわらず
				//最終的にそこに赤がある可能性が全く無くなる（移動先の結論には影響無し）
				if(ball[x] == 0){
					red[x] = false;
				}
			}
		}

		int count = 0;
		for(int i = 1; i < red.length; i++){
			if(red[i] && ball[i] != 0){
				count++;
			}
		}

		System.out.println(count);
	}

}
