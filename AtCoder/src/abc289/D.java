package abc289;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		
		boolean trap[] = new boolean[100_001];  
		for(int i = 0; i < m; i++) {
			trap[sc.nextInt()] = true;
		}
		
		int x = sc.nextInt();
		
		boolean dp[] = new boolean[x + 1];
		
		//今回はBFSで解いたが一方向かつ数パターンずつしか進めない上に値域も大きくないのでDFSでもおそらく解ける
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(0);
		while(!que.isEmpty()) {
			int tmp = que.removeFirst();
			
			if(dp[tmp]) {
				continue;
			}
			
			dp[tmp] = true;
			
			for(int i = 0; i < n; i++) {
				int next = tmp + a[i];
				if(next == x) {
					System.out.println("Yes");
					return;
				}
				if(next > x || dp[next] || trap[next]) {
					continue;
				}
				
				que.add(next);
			}
		}
		System.out.println("No");
	}
}