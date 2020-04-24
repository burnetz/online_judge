package arc024;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int shoe[][] = new int[2][41];

		int l = sc.nextInt();
		int r = sc.nextInt();

		for(int i = 0; i < l; i++){
			shoe[0][sc.nextInt()]++;
		}

		for(int i = 0; i < r; i++){
			shoe[1][sc.nextInt()]++;
		}

		int result = 0;

		for(int i = 0; i <= 40; i++){
			result += Math.min(shoe[0][i], shoe[1][i]);
		}

		System.out.println(result);

	}
}
