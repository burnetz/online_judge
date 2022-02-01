package arc134;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long l = sc.nextLong();
		long w = sc.nextLong();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		long count = 0;
		long prevRight = 0;
		for(int i = 0 ; i < n; i++) {
			if(a[i] > prevRight) {
				count += (a[i] - prevRight - 1)/w + 1;
			}
			prevRight = a[i] + w;
		}
		if(prevRight < l) {
			count += (l - prevRight - 1)/w + 1;
		}
		
		System.out.println(count);
	}
}