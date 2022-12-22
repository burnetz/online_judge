package abc282;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = "";
		
		for(char i = 'A' ; i < 'A' + n; i++) {
			s += i;
		}
		System.out.println(s);
	}
}