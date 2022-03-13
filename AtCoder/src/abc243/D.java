package abc243;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long x = sc.nextLong();
		char[] str = sc.next().toCharArray();
		
		ArrayDeque<Character> que = new ArrayDeque<Character>();
		
		//LUやRUあるいはもっと長いステップの無駄な動きを削除する。
		//最終的な答えはlongで収まる範囲なので途中の数字が過度に大きくなるものは無駄な動きを含んでいる。
		//これはスタックを使えば削除できる。
		for(int i = 0; i < n; i++) {
			char c = str[i];
			if(c == 'R' || c == 'L') {
				que.add(c);
			}
			else {
				if(!que.isEmpty() && que.getLast() != 'U') {
					que.removeLast();
				}
				else {
					que.add(c);
				}
			}
		}
		
		//無駄な動きを削除した後であれば普通に計算してもオーバーフローしない
		while(!que.isEmpty()) {
			char c = que.removeFirst();
			
			switch (c) {
			case 'U': 
				x /= 2;
				break;
			case 'L':
				x *= 2;
				break;
			case 'R':
				x *= 2;
				x++;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + c);
			}
			
		}
		
		System.out.println(x);
	}
}
