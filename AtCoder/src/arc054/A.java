package arc054;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int s = sc.nextInt();
		int d = sc.nextInt();
		
		//簡単のため原点スタートとなるように座標をずらす
		d -= s;
		if(d < 0) {
			d += l;
		}
		int d2 = d - l;
		
		int speedPos = x + y;
		int speedNeg = x - y;
		
		//時計回りに歩いたときの速さと反時計回りに歩いたときの速さ
		double t1 = (double)d/speedPos;
		double t2 = Double.MAX_VALUE;
		
		//反対側に歩いても正方向の場合は考える意味がないので
		//負方向に歩けるときだけ計算する
		if(speedNeg < 0) {
			t2 = (double)d2/speedNeg;
		}
		
		System.out.println(Math.min(t1, t2));
	}

}
