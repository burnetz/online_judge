package arc057;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		int k = sc.nextInt();
		
		//最初から2兆あるなら計算不要
		if(a >= 2_0000_0000_0000L) {
			System.out.println(0);
			return;
		}
		//k==0だとループ回すと間に合わないので引き算で出す
		if(k == 0) {
			System.out.println(2_0000_0000_0000L - a);
			return;
		}
		//k>=1ならループでも高速で終わる
		long count = 0;
		while(a < 2_0000_0000_0000L) {
			a += 1 + k*a;
			count++;
		}
		
		System.out.println(count);
	}

}
