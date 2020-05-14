package abc057;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		int minLen = Integer.MAX_VALUE;
		//これ以上は続けても桁数が逆転するだけ
		for(int i = 1; i <= Math.sqrt(n); i++){
			if(n % i != 0){
				continue;
			}
			String a = Integer.toString(i);
			String b = Long.toString(n / i);

			minLen = Math.min(minLen, Math.max(a.length(), b.length()));
		}

		System.out.println(minLen);
	}
}