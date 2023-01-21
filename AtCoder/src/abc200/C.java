package abc200;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int mod[] = new int[200];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			mod[a[i]%200]++;
		}
		
		long count = 0;
		
		for(int i = 0; i < n - 1; i++) {
			mod[a[i]%200]--;
			count += mod[a[i]%200];
		}
		
		System.out.println(count);
	}

}
