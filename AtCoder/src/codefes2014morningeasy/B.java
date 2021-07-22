package codefes2014morningeasy;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if((n - 1) / 20 % 2 == 0){
			System.out.println((n - 1)%20 + 1);
		}
		else{
			System.out.println(20 - (n - 1)%20);
		}
	}
}
