package abc200;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 0; i < k; i++) {
			if(n % 200 == 0) {
				n /= 200;
			}
			else {
				n *= 1000;
				n += 200;
			}
		}

		System.out.println(n);
	}

}
