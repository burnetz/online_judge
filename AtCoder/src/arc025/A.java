package arc025;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a[][] = new int[2][7];

		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 7; j++){
				a[i][j] = sc.nextInt();
			}
		}

		int result = 0;
		for(int i = 0; i < 7; i++){
			result += Math.max(a[0][i], a[1][i]);
		}

		System.out.println(result);
	}
}
