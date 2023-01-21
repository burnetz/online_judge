package abc185;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int nmax = n;
		int m = sc.nextInt();
		int t = sc.nextInt();
		int a[] = new int[m + 2];
		int b[] = new int[m + 2];

		for(int i = 1; i < m + 1; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		a[m + 1] = t;

		for(int i = 1; i < m + 2; i++){

			n -= a[i] - b[i - 1];
			if(n <= 0){
				System.out.println("No");
				return;
			}
			n += b[i] - a[i];
			n = Math.min(n, nmax);
		}

		System.out.println("Yes");
	}

}
