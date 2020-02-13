package abc150;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		sc.nextInt();
		
		String input = sc.next();
		String abc = "ABC";
		
		int count = 0;
		
		for(int i = 0; i < input.length() - abc.length() + 1; i++) {
			if(input.substring(i, i + abc.length()).equals(abc)) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
