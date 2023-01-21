package codefes2016qualb;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int passed = 0;
		int passedForeign = 0;
		
		String str = sc.next();
		for(int i = 0; i < n; i++) {
			char c = str.charAt(i);
			String result;
			
			switch(c) {
			case 'a':
				if(passed < a + b) {
					passed++;
					result = "Yes";
				}
				else {
					result = "No";
				}
				break;
			case 'b':
				if(passed < a + b && passedForeign < b) {
					passed++;
					passedForeign++;
					result = "Yes";
				}
				else {
					result = "No";
				}
				break;
			default:
				result = "No";
			}
			
			System.out.println(result);
		}
	}

}
