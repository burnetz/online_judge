package abc147;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int count = 0;
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i -1)){
				count++;
			}
		}
		
		System.out.println(count);
	}

}
