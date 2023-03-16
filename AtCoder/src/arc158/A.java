package arc158;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			long a[] = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
			
			//処理の前後で各要素の偶奇が必ず変わるので、もともと偶奇が一致していない場合は不可能
			if(a[0]%2 != a[1]%2 || a[1]%2 != a[2]%2) {
				System.out.println(-1);
				continue;
			}
			
			long sum = a[0] + a[1] + a[2];
			//処理の前後で合計は必ず15変化する。つまりもともと合計が3の倍数でない場合あとで均等に割れないため不可能
			if(sum%3 != 0) {
				System.out.println(-1);
				continue;
			}
			
			long average = sum / 3;
			long result = 0;
			//回数を求めるだけであれば(+3, +5, +7)ではなく(-2, 0, +2)で考えても同じ。
			//つまりもともとの平均に各要素を一致させれば良い。
			//そして上の処理で弾かれていない場合は必ず可能。
			for(int j = 0; j < 3; j++) {
				if(a[j] < average) {
					result += average - a[j];
				}
			}
			
			result /= 2;
			
			System.out.println(result);
		}
	}
}