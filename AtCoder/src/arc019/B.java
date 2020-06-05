package arc019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] name = sc.next().toCharArray();
		
		if(name.length == 1) {
			System.out.println(0);
			return;
		}
		//回文にならない原因を作っているペアの数を調べる
		int diffPair = 0;
		for(int i = 0; i < name.length/2; i++) {
			if(name[i] != name[name.length - i - 1]) {
				diffPair++;
			}
		}
		
		int result = 0;
		for(int i = 0; i < name.length/2; i++) {
			//もともと同じ文字のペアならどう書き換えても回文ではなくなる
			if(name[i] == name[name.length - i - 1]) {
				result += 50;
			}
			else {
				//ここ以外は既に回文になっているので反対側と同じ文字にしてはいけない
				if(diffPair == 1) {
					result += 48;
				}
				//こちらの分岐はもともと回文にできないので適当に書き換えればよい
				else {
					result += 50;
				}
			}
		}
		//長さが奇数の場合、真ん中以外が回文かどうかが重要
		if(name.length%2 == 1 && diffPair != 0) {
			result += 25;
		}
		
		System.out.println(result);
	}
}
