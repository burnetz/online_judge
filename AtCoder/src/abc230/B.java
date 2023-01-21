package abc230;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		
		int oIndex = input.indexOf('o');
		
		boolean flag = true;
		if(oIndex >= 3) {
			flag = false;
		}
		
		if(input.length() >= 3 && oIndex == -1) {
			flag = false;
		}
		
		for(int i = oIndex; i < input.length(); i += 3) {
			if(!flag) {
				break;
			}
			for(int j = i + 1; j < Math.min(input.length(), i + 3) ; j++) {
				if(input.charAt(j) == 'o') {
					flag = false;
					break;
				}
			}
		}
		
		System.out.println(flag ? "Yes" : "No");
	}
}

