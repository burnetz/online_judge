package abc227;

import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();

		long result = 0;
		
		//終了条件にこの条件を入れないと内側のijの計算でオーバーフローを起こす。
		for(int i = 1; i <= Math.min(n, 1_000_000); i++) {
			for(int j = i; j <= n; j++) {
				long ij = (long)i*j;
				
				if(ij > n) {
					break;
				}
				
				long upper = n/ij;
				
				if(upper < j) {
					break;
				}
				
				result += upper - j + 1;
			}
		}
		
		System.out.println(result);
	}
}