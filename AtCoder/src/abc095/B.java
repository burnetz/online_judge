package abc095;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		int m[] = new int[n];

		int minCost = Integer.MAX_VALUE;
		int total = 0;
		for(int i = 0; i < n; i++){
			m[i] = sc.nextInt();
			minCost = Math.min(minCost, m[i]);
			total += m[i];
		}


		System.out.println((x - total)/minCost + n);
	}
}
