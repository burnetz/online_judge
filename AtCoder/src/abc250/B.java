package abc250;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		boolean appear[] = new boolean[w + 1];
		for(int i = 0; i < n; i++) {
			if(a[i] <= w) {
				appear[a[i]] = true;
			}
			for(int j = i + 1; j < n; j++) {
				int tmp = a[i] + a[j];
				
				if(tmp <= w) {
					appear[tmp] = true;
				}
				for(int k = j + 1; k < n; k++) {
					tmp = a[i] + a[j] + a[k];
					
					if(tmp <= w) {
						appear[tmp] = true;
					}
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i <= w; i++) {
			if(appear[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}