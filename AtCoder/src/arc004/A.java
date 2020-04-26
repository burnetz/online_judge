package arc004;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int p[][] = new int[n][2];

		for(int i = 0; i < n; i++){
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}

		double result = 0;

		for(int i = 0; i < n; i++){
			for(int j = 1; j < n; j++){
				result = Math.max(result, dist(p[i][0], p[i][1], p[j][0], p[j][1]));
			}
		}

		System.out.println(result);
	}

	static double dist(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
