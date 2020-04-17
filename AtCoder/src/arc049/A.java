package arc049;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		System.out.print(str.substring(0, a)+"\""+str.substring(a, b)+"\""+
				str.substring(b, c)+"\""+str.substring(c, d)+"\"");
		if(d != str.length()) {
			System.out.print(str.substring(d, str.length()));
		}
		
		System.out.println();
	}
}