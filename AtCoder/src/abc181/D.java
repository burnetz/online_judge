package abc181;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		if(str.length() == 1) {
			if(str.equals("8")) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			
			return;
		}
		
		if(str.length() == 2) {
			int num1 = Integer.parseInt(str);
			int num2 = Integer.parseInt(str.charAt(1) + "" + str.charAt(0));
			
			if(num1 % 8 == 0 || num2 % 8 == 0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			return;
		}
		
		int digits[] = new int[10];
		
		for(int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			
			digits[tmp]++;
		}
		
loop:		for(int i = 104; i <= 992 ; i += 8) {
			int tmpDigits[] = new int[10];
			int tmpNum = i;
			for(int j = 0; j < 3; j++) {
				tmpDigits[tmpNum % 10]++;
				tmpNum /= 10;
			}
//			System.out.println(i);
			for(int j = 0; j < 10; j++) {
				if(tmpDigits[j] > digits[j]) {
//					System.out.println("failed "+j);
					continue loop;
				}
			}
			
			System.out.println("Yes");
			return;
		}
		
		System.out.println("No");
	}

}
