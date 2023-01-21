package abc252;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int value[] = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
			max = Math.max(max, value[i]);
		}
		
		boolean bad[] = new boolean[n];
		
		for(int i = 0; i < k; i++) {
			bad[sc.nextInt() - 1] = true;
		}
		
		for(int i = 0; i < n; i++) {
			if(value[i] == max && bad[i]) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
}