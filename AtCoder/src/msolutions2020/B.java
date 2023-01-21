package msolutions2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		while(a >= b){
			b *= 2;
			k--;
		}
		while(b >= c){
			c *= 2;
			k--;
		}
		if(k >= 0){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
