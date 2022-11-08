package abc276;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int index = -1;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') {
				index = i + 1;
			}
		}
		
		System.out.println(index);
	}
}