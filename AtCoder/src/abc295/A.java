package abc295;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String input[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.next();
			
			switch (input[i]) {
			case "and": 
			case "not": 
			case "that": 
			case "the": 
			case "you": 
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
		
	}		
}