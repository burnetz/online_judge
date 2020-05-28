package abc016;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		String result = "";

		if(b == 0){
			if(a + b == c){
				result = "?";
			}
			else {
				result = "!";
			}
		}
		else {
			if(a + b == c){
				result = "+";
			}
			else if(a - b == c){
				result = "-";
			}
			else {
				result = "!";
			}
		}

		System.out.println(result);
	}
}