package abc181;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long sum = 0;

		for(int i = 0; i < n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			sum += (long)(b - a + 1)*(a + b)/2;
		}

		System.out.println(sum);
	}

}
