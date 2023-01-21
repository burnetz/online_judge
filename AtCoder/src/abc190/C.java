package abc190;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		a = new int[m];
		b = new int[m];

		for(int i = 0; i < m; i++){
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
		}
		int k = sc.nextInt();

		c = new int[k];
		d = new int[k];

		for(int i = 0; i < k; i++){
			c[i] = sc.nextInt() - 1;
			d[i] = sc.nextInt() - 1;
		}

		balls = new int[n];

		dfs(0, k);

		System.out.println(result);
	}

	static int a[];
	static int b[];
	static int c[];
	static int d[];
	static int balls[];
	static int result = 0;

	//Kの値が非常に小さいので全探索でも十分間に合う
	static void dfs(int depth, int n){
		if(depth == n){
			int tmp = 0;
			for(int i = 0; i < a.length; i++){
				if(balls[a[i]] > 0 && balls[b[i]] > 0){
					tmp++;
				}
			}

			result = Math.max(result, tmp);

			return;
		}

		balls[c[depth]]++;
		dfs(depth + 1, n);
		balls[c[depth]]--;

		balls[d[depth]]++;
		dfs(depth + 1, n);
		balls[d[depth]]--;
	}

}
