package arc128;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			int a[] = new int[3];
			
			for(int j = 0; j < 3; j++) {
				a[j] = sc.nextInt();
			}
			
			int result = Integer.MAX_VALUE;
			
			//大小関係を明らかにしておくと楽
			Arrays.sort(a);
			
			//全部赤にする場合かつ緑<=青である場合を考える。
			//まずは緑の分だけ緑青を全て赤にする。
			//青が残るので青赤で緑2個生成→青緑で赤2個生成→青緑で赤2個生成を繰り返す。
			//なおこれを行うためには青と緑の差が3の倍数である必要がある。
			
			//その検証を3色について行い最小の値が答え
			if((a[1] - a[0]) % 3 == 0) {
				result = Math.min(a[1], result);
			}
			if((a[2] - a[0]) % 3 == 0) {
				result = Math.min(a[2], result);
			}
			if((a[2] - a[1]) % 3 == 0) {
				result = Math.min(a[2], result);
			}
			
			if(result < Integer.MAX_VALUE) {
				System.out.println(result);
			}
			else {
				System.out.println(-1);
			}
		}
	}		
}