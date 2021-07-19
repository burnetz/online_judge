package abc201;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int count = 0;
		
loop:		for(int i = 0; i < 10000; i++) {
			String numStr = String.format("%04d", i);
			
			for(int j = 0; j < 10; j++) {
				char tmpC = str.charAt(j);
				
				if(tmpC == 'o' && numStr.indexOf(j + '0') < 0) {
					continue loop;
				}
				
				if(tmpC == 'x' && numStr.indexOf(j + '0') >= 0) {
					continue loop;
				}
			}
			
			count++;
		}
		
		System.out.println(count);
	}

}

