package abc246;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(k == 0) {
				break;
			}
			
			int use = Math.min(k, a[i]/x);
			
			a[i] -= use*x;
			k -= use;
		}
		
		Arrays.sort(a);
		
		long sum = 0;
		for(int i = 0; i < n - k; i++) {
			sum += a[i];
		}
		
		System.out.println(sum);
	}
}
