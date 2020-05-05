package abc112;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		int minCost = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++){
			int tmpC = sc.nextInt();
			int tmpT = sc.nextInt();

			if(tmpT <= t){
				minCost = Math.min(tmpC, minCost);
			}
		}

		System.out.println(minCost == Integer.MAX_VALUE ? "TLE" : minCost);

	}

}
