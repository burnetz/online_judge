package abc174;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long d = sc.nextInt();

		int count = 0;
		for(int i = 0; i < n; i++){
			long x = sc.nextLong();
			long y = sc.nextLong();

			long distPow2 = x*x + y*y;
			if(distPow2 <= d*d){
				count++;
			}
		}

		System.out.println(count);
	}
}
