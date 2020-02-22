package abc151;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();

		int sum = 0;
		
		int goal = n*m;
		
		for(int i = 0; i < n - 1; i++) {
			sum += sc.nextInt();
		}
		
		if(goal - sum <= k) {
			System.out.println(Math.max(0, goal - sum));
		}
		else {
			System.out.println(-1);
		}
	}

}
