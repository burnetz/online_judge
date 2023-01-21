package arc129;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int currentLeft = 0;
		int currentRight = Integer.MAX_VALUE;
		//距離の最大値なので結果は単調増加になる。
		//左側と右側もそれぞれ最大、最小だけ記憶すればよい
		for(int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			currentLeft = Math.max(currentLeft, l);
			currentRight = Math.min(currentRight, r);
			//ここまでの区間全てに共通部分がある場合の分岐
			//自明に答えは0
			if(currentLeft <= currentRight) {
				System.out.println(0);
			}
			//左側と右側が逆転した場合はその中点が最適解
			else {
				int mid = (currentLeft + currentRight)/2;
				System.out.println(currentLeft - mid);
			}
		}
	}		
}