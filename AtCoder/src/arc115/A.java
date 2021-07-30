package arc115;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int odd = 0;
		int even = 0;
		
		//正答数が同じになる可能性のある2人は1と答えた数の偶奇が一致する
		//（同じ解答なら当然一致、違う解答で正答数が同じになる条件は残りの問題の半分で1と答えることが条件）
		for(int i = 0; i < n; i++) {
			int tmp = 0;
			String str = sc.next();
			
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == '1') {
					tmp++;
				}
			}
			
			if(tmp % 2 == 0) {
				even++;
			}
			else {
				odd++;
			}
		}
		
		//最終的な答えは(1が奇数回の人数)*(1が偶数回の人数)で出せる
		System.out.println((long)odd*even);
	}
}

