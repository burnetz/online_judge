package vol26;

import java.util.Scanner;

public class FastDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result;
 
		/*
		 * 1がp-1回続く整数は等比数列の和から(10^(p-1) - 1)/9　と表せるので
		 * フェルマーの小定理から10とpが互いに素かつ9とpが互いに素なら分子が0になる。
		 * n>=3なら上記の点はクリアできているので0と決め打ち
		 */
		switch (n) {
		case 0:
		case 2:
			result = 1;
			break;
		case 1:
			result = 2;
			break;
		default:
			result = 0;
			break;
		}
		
		System.out.println(result);
	}

}
