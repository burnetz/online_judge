package abc287;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String s[] = new String[n];
		String t[] = new String[m];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next().substring(3);
		}
		
		for(int i = 0; i < m; i++) {
			t[i] = sc.next();
		}
		
		int count = 0;
		Arrays.sort(t);
		for(int i = 0; i < n; i++) {
			if(Arrays.binarySearch(t, s[i]) >= 0) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
