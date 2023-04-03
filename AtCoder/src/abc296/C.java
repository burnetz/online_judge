package abc296;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long x = sc.nextLong();
		long a[] = new long[n];
		
		HashSet<Long> set = new HashSet<Long>();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			set.add(a[i]);
		}
		
		for(int i = 0; i < n; i++) {
			if(set.contains(a[i] + x) || set.contains(a[i] - x)) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
		
	}
}