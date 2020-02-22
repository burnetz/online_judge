package abc146;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int result = 0;
		
		switch (str) {
		case "SAT":
			result = 1;
			break;
		case "SUN":
			result = 7;
			break;
		case "MON":
			result = 6;
			break;
		case "TUE":
			result = 5;
			break;
		case "WED":
			result = 4;
			break;
		case "THU":
			result = 3;
			break;

		default:
			result = 2;
			break;
		}
		
		System.out.println(result);
	}

}
