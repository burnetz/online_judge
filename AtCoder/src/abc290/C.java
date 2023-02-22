package abc290;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a[] = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		int count = 0;
		for(int i = 0; i < n ; i++) {
			if(!set.contains(a[i])) {
				set.add(a[i]);
				count++;
				
				if(count == k) {
					break;
				}
			}
		}
		
		for(int i = 0; ; i++) {
			if(!set.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
}
