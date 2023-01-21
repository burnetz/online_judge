package arc136;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		StringBuffer sb = new StringBuffer();
		StringBuffer tmpSb = new StringBuffer();

		for(int i = 0; i < n; i++) {
			if(str[i] == 'C') {
				sb.append(compress(tmpSb.toString()));
				tmpSb = new StringBuffer();
				sb.append('C');
			}
			else {
				tmpSb.append(str[i]);
			}
		}
		
		sb.append(compress(tmpSb.toString()));
		
		System.out.println(sb);
	}

	static String compress(String str) {
		int a = 0;
		int b = 0;

		for(int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)){
			case 'A': 
				a++;
				break;
			case 'B':
				b++;
				break;
			default:
				System.out.println("ERROR");
				System.exit(0);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < a + b/2; i++) {
			sb.append('A');
		}
		if(b % 2 == 1) {
			sb.append('B');
		}
		
		return sb.toString();
	}
}