package codefes2014final;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if(n == 1) {
			System.out.println("1 1");
		}
		//1以外の任意の数は必ずどこかの段の左から2番目に現れる
		else {
			System.out.println((n + 1) + " " + 2);
		}
	}
}
