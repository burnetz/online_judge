package abc225;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long array[][] = new long[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				array[i][j] = sc.nextLong();
			}
		}
		
		if((array[0][0] - 1)%7 > (7 - m)) {
			System.out.println("No");
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i != 0 && array[i][j] != array[i - 1][j] + 7) {
					System.out.println("No");
					return;
				}
				
				if(j != 0 && array[i][j] != array[i][j - 1] + 1) {
					System.out.println("No");
					return;
				}
			}
		}
		
		System.out.println("Yes");
	}
}