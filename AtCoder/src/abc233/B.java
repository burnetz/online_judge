package abc233;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt() - 1;
		int r = sc.nextInt();
		String input = sc.next();
		
		String str1 = input.substring(0, l);
		String str2 = new StringBuffer(input.substring(l, r)).reverse().toString();
		String str3 = input.substring(r);
		
		System.out.println(str1 + str2 + str3);
	}
}

