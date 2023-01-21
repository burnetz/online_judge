package codefes2014qualb;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i = 0; i < str.length() ; i++) {
			int num = str.charAt(str.length() - i - 1) - '0';
			if(i % 2 == 0) {
				oddSum += num;
			}
			else {
				evenSum += num;
			}
		}
		
		System.out.println(evenSum + " "+ oddSum);
		
		
	}

}
