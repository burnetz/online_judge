package abc243;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			set.add(a[i]);
		}
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
			
			if(a[i] == b[i]) {
				count1++;
			}
			
			else if(set.contains(b[i])) {
				count2++;
			}
		}
		
		System.out.println(count1);
		System.out.println(count2);
	}
}

