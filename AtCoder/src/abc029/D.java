package abc029;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(solve(n));
	}

	static int nines[] = {0,9,99,999,9999,99999,999999,9999999,99999999,999999999};

	//再帰で解くことが可能
	static int solve(int num){
		String numStr = Integer.toString(num);
		if(num == 0){
			return 0;
		}
		else if(num <= 9){
			return 1;
		}

		int len = numStr.length();

		int result = 0;

		//数字の先頭が1のとき、半端な部分については毎回1が1個付与されることを念頭に式を作る
		if(numStr.charAt(0) == '1'){
			result += solve(nines[len - 1]);
			result += solve((int)(num % Math.pow(10, len - 1))) + num - nines[len - 1]	;
		}
		//先頭の数字が2以上のとき、半端な部分は普通に再帰するだけで良いが
		//例えば200以上999以下のときは100~199で1が100回付与されることを考慮する
		else {
			int top = numStr.charAt(0) - '0';
			result += solve(nines[len - 1])*top + Math.pow(10, len - 1);
			result += solve((int)(num % Math.pow(10, len - 1)));
		}

		return result;
	}

}