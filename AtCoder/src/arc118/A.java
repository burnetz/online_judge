package arc118;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		long n = sc.nextLong();
		
		//飛ぶのはA*tが100の倍数を超えた瞬間
		//不等式を解くことで飛んだ回数から逆算できる
		long result = 100*n/t;
		
		//通常、n番目までにn回数字が飛んでいる。
		//ただしちょうどn*tが100の倍数になったときはn - 1回しか飛んでない
		if(100*n % t == 0) {
			result += n - 1;
		}
		else {
			result += n;
		}
		System.out.println(result);
	}
}