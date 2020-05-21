package abc028;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String result;
		if(n <= 59){
			result = "Bad";
		}
		else if(n <= 89){
			result = "Good";
		}
		else if(n <= 99){
			result = "Great";
		}
		else {
			result = "Perfect";
		}

		System.out.println(result);
	}

}