package abc279;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		//操作回数についての関数と考え、極小値をとるxを計算する。
		double x = Math.pow((double)a/(2*b), (double)2/3) - 1;
		
		//極小値が負の場合は0回が最適。
		if(x < 0) {
			System.out.println(calc(a, b, 1, 0));
		}
		//極小値が正のとき、操作回数は整数であることに注意する。
		//その際切り捨てと切り上げのうち最適なほうを選ぶ。
		else {
			double y1 = calc(a, b, 1, Math.floor(x));
			double y2 = calc(a, b, 1, Math.ceil(x));
			
			System.out.println(Math.min(y1, y2));
		}
	}
	
	static double calc (long a, long b, long g, double x) {
		return (double)a/Math.sqrt(g + x) + b*x;
	}
}