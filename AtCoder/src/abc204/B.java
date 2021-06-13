package abc204;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int sum = 0;

		for(int i = 0; i < n; i++){
			sum += Math.max(sc.nextInt() - 10, 0);
		}
		System.out.println(sum);
	}

}
