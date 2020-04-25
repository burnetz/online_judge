package arc017;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();


		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}
