package abc234;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		
		long result = Long.MAX_VALUE;
		
		//最初の桁は9パターン、公差は20パターン弱、桁数も20桁未満なので
		//全部のパターンを考慮しても十分間に合う。
		for(int i = 1; i <= 9; i++) {
loop:			for(int j = -9; j <= 9; j++) {
				int digit = i;
				long tmpResult = digit;
				while(tmpResult < x) {
					tmpResult *= 10;
					digit += j;
					
					if(digit > 9 || digit < 0) {
						continue loop;
					}
					tmpResult += digit;
				}
				result = Math.min(result, tmpResult);
			}
		}
		
		System.out.println(result);
	}
	
}
