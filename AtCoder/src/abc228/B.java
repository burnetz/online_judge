package abc228;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt() - 1;
		
		boolean knew[] = new boolean[n];
		
		int next[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			next[i] = sc.nextInt() - 1;
		}
		
		int current = x;
		int count = 0;
		while(true) {
			if(knew[current]) {
				break;
			}
			
			count++;
			knew[current] = true;
			current = next[current];
		}
		
		System.out.println(count);
	}
}

