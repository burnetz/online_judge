package abc289;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i] == '0' ? 1 : 0);
		}		
		System.out.println();
	}		
}