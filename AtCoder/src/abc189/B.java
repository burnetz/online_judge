package abc189;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double x = sc.nextInt() * 100;
		
		double sum = 0;
		for(int i = 0; i < n; i++) {
			double v = sc.nextInt();
			double p = sc.nextDouble();
			
			sum += v*p;
			
			if(x < sum) {
				System.out.println(i + 1);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
