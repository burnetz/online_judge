package abc198;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long r = sc.nextLong();
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		long dist = x*x + y*y;

		long result = 0;
		//距離がRよりも近いと逆に2ターンかかってしまう
		if(dist < r*r) {
			result = 2;
		}
		else {
			//それ以外であればちょうどRの整数倍なら単純に割り算
			//Rの整数倍より若干近い場合は最後の2ターンで調節が可能なので端数切り上げでよい
			result = (long)Math.ceil(Math.sqrt((double)dist/(r*r)));
		}
		
		System.out.println(result);
	}

}
