package arc012;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String day = sc.next();

		int result = 0;

		switch(day){
		case "Monday":
			result = 5;
			break;
		case "Tuesday":
			result = 4;
			break;
		case "Wednesday":
			result = 3;
			break;
		case "Thursday":
			result = 2;
			break;
		case "Friday":
			result = 1;
			break;
		}

		System.out.println(result);
	}
}
