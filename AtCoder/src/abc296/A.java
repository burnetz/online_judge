package abc296;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();
		
		for(int i = 0; i < n - 1; i++) {
			if(str[i] == str[i + 1]) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
		
	}		
}