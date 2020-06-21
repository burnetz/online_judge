package abc171;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];

		int count[] = new int[1_00001];
		long sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			count[a[i]] ++;
			sum += a[i];
		}

		int q = sc.nextInt();

		for(int i = 0; i < q; i++){
			int b = sc.nextInt();
			int c = sc.nextInt();

			sum += (long)(c - b)*count[b];
			count[c] += count[b];
			count[b] = 0;

			System.out.println(sum);
		}

//		long sum = 0;
//		for(int i = 0; i < 1_00001; i++){
//			sum += (long)count[i]*i;
//		}
//
//		System.out.println(sum);
	}
}
