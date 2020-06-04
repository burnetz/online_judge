package abc005;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int n = sc.nextInt();
		
		int stock[] = new int[101];
		for(int i = 0; i < n; i++) {
			stock[sc.nextInt()]++;
		}
		int m = sc.nextInt();
		int b[] = new int[m];

		for(int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}

		for(int i = 0; i < m; i++) {
			boolean exist = false;
			for(int j = Math.max(b[i] - t, 0) ; j <= b[i]; j++) {
				if(stock[j] > 0) {
					stock[j]--;
					exist = true;
					break;
				}
			}
			
			if(!exist) {
				System.out.println("no");
				return;
			}
		}
		
		System.out.println("yes");
	}
}