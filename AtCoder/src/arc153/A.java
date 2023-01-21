package arc153;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt() - 1;
		char[] nStr = String.format("%06d", n).toCharArray();
		String result = "" + (char)(nStr[0] + 1) + (char)(nStr[0] + 1) + 
				nStr[1] + nStr[2] + nStr[3] + nStr[3] + 
				nStr[4] + nStr[5] + nStr[4];
		System.out.println(result);
	}
}