package abc114;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		String result = "NO";

		switch(x){
		case 3:
		case 5:
		case 7:
			result = " YES";

		}

		System.out.println(result);

	}

}
