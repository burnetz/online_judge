package abc169;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long result = 1;
		long limit = 1_000_000_000_000_000_000L;

		long a[] = new long[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextLong();

			if(a[i] == 0){
				System.out.println(0);
				return;
			}
		}
		for(int i = 0; i < n; i++){

			if(limit/result < a[i]){
				System.out.println(-1);
				return;
			}
			result *= a[i];
		}

		System.out.println(result);
	}

}
