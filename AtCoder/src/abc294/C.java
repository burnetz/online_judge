package abc294;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int c1[] = new int[n + m];
		int c2[] = new int[n + m];
		
		for(int i = 0; i < n + m; i++) {
			c1[i] = sc.nextInt();
			c2[i] = c1[i];
		}
		
		Arrays.sort(c2);
		
		for(int i = 0; i < n + m; i++) {
			int index = Arrays.binarySearch(c2, c1[i]);
			
			System.out.print(index + 1 + " ");
			
			if(i == n - 1) {
				System.out.println();
			}
		}
	}
}