package abc125;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		used = new boolean[n];
		v = new int[n];
		c = new int[n];

		for(int i = 0; i < n; i++){
			v[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			c[i] = sc.nextInt();
		}

		System.out.println(dfs(0, n));

	}

	static boolean used[];
	static int v[];
	static int c[];

	static int dfs(int depth, int n){
		if(depth == n){
			int result = 0;
			for(int i = 0; i < n; i++){
				if(used[i]){
					result += v[i] - c[i];
				}
			}

			return result;
		}

		int result = Integer.MIN_VALUE;;
		used[depth] = false;
		result = Math.max(result, dfs(depth + 1, n));
		used[depth] = true;
		result = Math.max(result, dfs(depth + 1, n));

		return result;
	}
}
