package arc142;

import java.util.HashSet;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		StringBuffer sb = new StringBuffer(sc.next());
		long input1 = Long.parseLong(sb.toString());
		//もともとの入力を左右反転したもの
		long input2 = Long.parseLong(sb.reverse().toString());
		
		//反転すると小さくなるならどうやってもf(x)=kにはできない
		if(input1 > input2) {
			System.out.println(0);
			return;
		}

		//1回反転すると左右のいずれにも0がなくなるので
		//1桁目に0があるような数字を作れるのはその数字自身しかない。
		if(input1 % 10 == 0) {
			System.out.println(1);
			return;
		}
		
		//ここからは重複がありえるのでsetで管理
		HashSet<Long> set = new HashSet<Long>();

		if(input1 <= n) {
			set.add(input1);
		}
		if(input2 <= n) {
			set.add(input2);
		}

		//ここに来ている時点で最終型の1の位は0ではないので
		//核となる数字のブロックに0を追加しnより小さいもの全てが答えになる
		while(true) {
			input1 *= 10;

			if(input1 <= n) {
				set.add(input1);
			}
			else {
				break;
			}
		}

		while(true) {
			input2 *= 10;

			if(input2 <= n) {
				set.add(input2);
			}
			else {
				break;
			}
		}
		System.out.println(set.size());
	}

}