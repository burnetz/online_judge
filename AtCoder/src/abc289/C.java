package abc289;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		used = new boolean[m];
		
		sets = new Set[m];
		
		for(int i = 0; i < m; i++) {
			int c = sc.nextInt();
			
			sets[i] = new HashSet<Integer>();
			for(int j = 0; j < c; j++) {
				sets[i].add(sc.nextInt());
			}
		}
		
		System.out.println(dfs(0, m, n));
	}
	
	static boolean[] used;
	static Set<Integer>[] sets;
	
	static int dfs(int depth, int maxDepth, int maxN) {
		if(depth == maxDepth) {
			Set<Integer> set = new HashSet<Integer>();
			
			for(int i = 0; i < maxDepth; i++) {
				if(used[i]) {
					for(int j = 1; j <= maxN ; j++) {
						if(sets[i].contains(j)) {
							set.add(j);
						}
					}
				}
			}
			
			if(set.size() == maxN) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int result = 0;
		used[depth] = true;
		result += dfs(depth + 1, maxDepth, maxN);
		used[depth] = false;
		result += dfs(depth + 1, maxDepth, maxN);

		return result;
	}
}

