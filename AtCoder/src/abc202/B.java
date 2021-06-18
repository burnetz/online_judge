package abc202;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		for(int i = 0; i < str.length; i++) {
			switch (str[i]) {
			case '6':
				str[i] = '9';
				break;
			case '9':
				str[i] = '6';
				break;

			default:
				break;
			}
		}
		
		System.out.println(new StringBuffer(new String(str)).reverse());
	}

}
