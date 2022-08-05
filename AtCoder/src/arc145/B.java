package arc145;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long div = n/a;
		long mod = n%a;
		
		//i < aのとき必ずAが負けるので以下の場合は自明に0
		if(div == 0) {
			System.out.println(0);
			return;
		}
		
		//i >= aのとき1ターン目にAが取るべき戦略は取れるだけ石を取り除くこと。
		//その後でBが行動不可ならAの勝ち、行動可能なら必ずBの勝ち。
		//該当するパターン数はmodおよびa,bの大小関係で計算可能
		long result = Math.min(mod + 1, b);
		result += Math.min(a, b) * (div - 1);
		
		System.out.println(result);
		
	}

}