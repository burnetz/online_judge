package arc151;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		
		char[] result = new char[n];
		
		Arrays.fill(result, '0');
		
		int typeA = 0;
		int typeB = 0;
		
		for(int i = 0; i < n; i++) {
			if(s[i] != t[i]) {
				if(s[i] == '0') {
					typeA++;
				}
				else {
					typeB++;
				}
			}
		}
		
		if((typeA - typeB)%2 != 0) {
			System.out.println(-1);
			return;
		}
		
		if(typeA > typeB) {
			int change = (typeA - typeB) / 2;
			
			for(int i = n - 1; i >= 0 && change > 0 ; i--) {
				if(s[i] == '0' && t[i] == '1') {
					result[i] = '1';
					change--;
				}
			}
		}
		
		if(typeB > typeA) {
			int change = (typeB - typeA) / 2;
			
			for(int i = n - 1; i >= 0 && change > 0 ; i--) {
				if(s[i] == '1' && t[i] == '0') {
					result[i] = '1';
					change--;
				}
			}
			
		}
		
		System.out.println(result);
	}
}