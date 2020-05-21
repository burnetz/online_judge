package abc029;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		pw = new char[n];

		dfs(0, n);
	}

	static char[] pw;
	static char[] c = {'a', 'b', 'c'};

	static void dfs(int depth, int n){
		if(depth == n){
			System.out.println(pw);
			return;
		}

		for(int i = 0; i < 3; i++){
			pw[depth] = c[i];
			dfs(depth + 1, n);
		}
	}
}

