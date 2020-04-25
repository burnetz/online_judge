package arc011;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int N = sc.nextInt();

		int sales = N;
		while(N >= m){
			sales += N/m*n;
			N = N - N/m*m + N/m*n;
		}

		System.out.println(sales);
	}
}
