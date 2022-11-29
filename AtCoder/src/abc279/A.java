package abc279;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		
		int result = 0;
		
		for(int i = 0; i < str.length; i++) {
			if(str[i] == 'v') {
				result += 1;
			}
			else {
				result += 2;
			}
		}
		
		System.out.println(result);
	}
}