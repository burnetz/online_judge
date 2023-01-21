package abc186;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int a[][] = new int[h][w];
		int min = 100;
		int sum = 0;

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				a[i][j] = sc.nextInt();
				min = Math.min(min, a[i][j]);
				sum += a[i][j];
			}
		}


		System.out.println(sum - min*h*w);
	}

}
