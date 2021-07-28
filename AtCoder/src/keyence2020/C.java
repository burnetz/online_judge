package keyence2020;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int s = sc.nextInt();

		//ルール上は部分列の長さは1でも良いので
		//基本的にはsをk個並べるだけ
		for(int i = 0; i < k; i++) {
			System.out.print(s);
			if(i != n - 1) {
				System.out.print(" ");
			}
		}
		
		//残りは他の部分列の和がsにならないよう気をつけて埋める
		//基本的にs+1で埋めれば確実
		for(int i = k; i < n; i++) {
			//ただしsが上限値のときは制約上1を足せないので1で埋める
			//1だけならどう足しても1000000000にならない
			if(s == 1_000_000_000) {
				System.out.print(1);
			}
			else {
				System.out.print(s + 1);
			}
			
			if(i != n - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
