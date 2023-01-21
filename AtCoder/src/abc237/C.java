package abc237;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int n = str.length();
		int start = 0;
		int end = str.length();
		for(int i = 0; i < n; i++) {
			if(str.charAt(i) != 'a') {
				start = i;
				break;
			}
		}
		
		for(int i = n - 1; i >= 0; i--) {
			if(str.charAt(i) != 'a') {
				end = i + 1;
				break;
			}
		}
		
		if(start > n - end) {
			System.out.println("No");
			return;
		}
		
		for(int i = start; i < end; i++, end--) {
			if(str.charAt(i) != str.charAt(end - 1)) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}