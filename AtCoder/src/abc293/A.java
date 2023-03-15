package abc293;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		for(int i = 0; i < str.length / 2; i++) {
			System.out.print(str[2*i + 1] + "" + str[2*i]);
		}
	}		
}