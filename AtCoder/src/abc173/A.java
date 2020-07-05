package abc173;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if(n % 1000 == 0){
			System.out.println(0);
		}
		else {
			System.out.println(1000 - (n % 1000));
		}
	}

}
