package abc296;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		for(int i = 0; i < 8; i++) {
			char[] str = sc.next().toCharArray();
			
			for(int j = 0; j < 8; j++) {
				if(str[j] == '*') {
					System.out.println( (char)(j + 'a') + "" + (8 - i));
				}
			}
		}
	}		
}