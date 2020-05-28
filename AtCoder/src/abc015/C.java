package abc015;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		matrix = new int[n][k];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < k; j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		answer = new int[n];

		dfs(0, n, k);

		System.out.println("Nothing");
	}

	static int matrix[][];
	static int answer[];

	static void dfs(int depth, int n, int k){
		if(n == depth){
			int result = matrix[0][answer[0]];

			for(int i = 1; i < n; i++){
				result ^= matrix[i][answer[i]];
			}

			if(result == 0){
				System.out.println("Found");
				System.exit(0);
			}
			return;
		}

		for(int i = 0; i < k; i++){
			answer[depth] = i;
			dfs(depth + 1, n, k);
		}
	}
}