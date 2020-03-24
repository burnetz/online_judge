package abc126;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		char[] str = sc.next().toCharArray();
		
		str[k - 1] += 32;
		
		System.out.println(str);
	}

}
