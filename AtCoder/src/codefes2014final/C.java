package codefes2014final;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		//f(i)の値自体を順に調べても十分間に合う
		for(int i = 10; i <= 20000; i++) {
			long tmpN = i;
			long tmpSum = 0;
			long tmpOffset = 1;
			
			while(tmpN > 0) {
				tmpSum += tmpOffset*(tmpN % 10);
				
				tmpN /= 10;
				tmpOffset *= i;
			}
			if(tmpSum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
