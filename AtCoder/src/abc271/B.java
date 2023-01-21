package abc271;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int[][] array = new int[n][];
		
		for(int i = 0; i < n; i++) {
			int l = sc.nextInt();
			array[i] = new int[l];
			for(int j = 0; j < l; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < q; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			
			System.out.println(array[s][t]);
		}
	}
}
 
	