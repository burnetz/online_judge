package arc032;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if(n == 1){
			System.out.println("BOWWOW");
			return;
		}

		int result = n*(n + 1)/2;

		for(int i = 2; i < Math.sqrt(result); i++){
			if(result % i == 0){
				System.out.println("BOWWOW");
				return;
			}
		}

		System.out.println("WANWAN");

	}
}
