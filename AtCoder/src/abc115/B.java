package abc115;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int max = 0;
		int sum = 0;

		for(int i = 0; i < n; i++){
			int p = sc.nextInt();

			sum += p;
			max = Math.max(max, p);
		}

		System.out.println(sum - max/2);

	}

}
