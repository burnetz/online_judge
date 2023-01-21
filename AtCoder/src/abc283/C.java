package abc283;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		int count = 0;
		int zero = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i] == '0') {
				zero++;
			}
			else {
				zero = 0;
			}
			
			if(zero == 2) {
				count++;
				zero = 0;
			}
		}
		
		System.out.println(str.length - count);
	}
}

