package abc115;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();
		String result = "";

		switch(d){
		case 22:
			result += " Eve";
		case 23:
			result += " Eve";
		case 24:
			result += " Eve";
		case 25:
			result = "Christmas" + result;

		}

		System.out.println(result);

	}

}
