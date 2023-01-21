package abc183;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		k = sc.nextLong();

		used = new boolean[n];
		
		matrix = new long[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextLong();
			}
		}
		
		dfs(0, 0, 0, n);
		
		System.out.println(count);
	}
	
	static boolean used[];
	static long k;
	static long[][] matrix;
	static int count = 0;
	
	static void dfs(int start, long sum, int currentDepth, int n) {
		if(currentDepth == n - 1) {
			if(sum + matrix[start][0] == k) {
				count++;
			}
			return;
		}
		
		used[start] = true;
		
		for(int i = 0; i < n; i++) {
			if(!used[i] && matrix[start][i] != 0) {
				dfs(i, sum + matrix[start][i], currentDepth + 1, n);
			}
		}
		
		used[start] = false;
	}
}
