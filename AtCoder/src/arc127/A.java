package arc127;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long count = 0;
		
		String ones = "1";
		String ceil = "2";
	
		//求める答えは「1で始まる数字」「11で始まる数字」「111で始まる数字」...の個数の和と言い換えられる。
		//例えば111であれば「1」「11」「111」の3つの集合に属するので確かにf(111)=3と一致する。
		for(int i = 0; i <= 16; i++) {
			long onesNum = Long.parseLong(ones); //11...1
			long ceilNum = Long.parseLong(ceil); //11..12
			
			for(int j = 0; j < 18 - i; j++) {
				//nと11...2はいずれも上限として考慮しなければならないが
				//nはギリギリ含んで良いので注意
				count += Math.max(0, Math.min(ceilNum - 1, n) - onesNum + 1);
				onesNum *= 10;
				ceilNum *= 10;
			}
			
			ones += "1";
			ceil = "1" + ceil;
		}
		
		System.out.println(count);
	}
}