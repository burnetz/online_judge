package abc234;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int x[] = new int[n];
		int y[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		double result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int dx = x[i] - x[j];
				int dy = y[i] - y[j];
				double tmp = Math.sqrt(dx*dx + dy*dy);
				result = Math.max(result, tmp);
			}
		}
		
		System.out.println(result);
		
	}
}

