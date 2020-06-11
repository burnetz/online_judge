package arc054;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double p = sc.nextDouble();

		//合計時間はy = x + p/2^(x/1.5)なので微分して極小値を求めれば適切なxが分かる
		double c = 2.16404;

		double x = -c*Math.log(c/p);

		//ただし上記で求めたxが負のときは今すぐコンピュータを稼働させれば良いということ
		System.out.println(x >= 0 ? x + p/Math.pow(2, x/1.5) : p);
	}

}
