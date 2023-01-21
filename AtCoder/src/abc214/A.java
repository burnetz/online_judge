package abc214;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = 0;

		if(n <= 125){
			result = 4;
		}
		else if(n <= 211){
			result = 6;
		}
		else{
			result = 8;
		}

		System.out.println(result);
	}

}
