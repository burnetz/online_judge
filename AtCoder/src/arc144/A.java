package arc144;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		String str = "";
		System.out.println(2*n);
		
		while(n > 0) {
			str = Math.min(4, n) + str;
			n -= 4;
		}
		
		System.out.println(str);
	}

}