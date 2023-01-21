package arc126;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i = 0; i < t; i++){
			long n2 = sc.nextLong();
			long n3 = sc.nextLong();
			long n4 = sc.nextLong();

			//長さ3は必ず2本組でしか使えないので2で割ってしまう
			n3 /= 2;

			long result = 0;

			//最も使いづらい長さ3の棒から優先的に使う。
			//2と4では4のほうが使いにくいのでまずは3,3,4のパターン
			long tmp = Math.min(n3, n4);
			result += tmp;
			n3 -= tmp;
			n4 -= tmp;

			//3,3,2,2のパターン
			tmp = Math.min(n3, n2/2);
			result += tmp;
			n3 -= tmp;
			n2 -= tmp*2;

			//ここでもなるべく使いにくい棒から消化するために4,4,2を先に考える
			tmp = Math.min(n4/2, n2);
			result += tmp;
			n4 -= tmp*2;
			n2 -= tmp;

			//4,2,2,2のパターン
			tmp = Math.min(n4, n2/3);
			result += tmp;
			n4 -= tmp;
			n2 -= tmp*3;

			//2,2,2,2,2のパターンで全網羅
			result += n2/5;

			System.out.println(result);
		}
	}
}