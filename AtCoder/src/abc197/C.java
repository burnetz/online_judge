package abc197;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		//パーティションは最低n-1個で良いがn個のほうが処理が楽
		part = new boolean[n];
		part[n - 1] = true;
		
		dfs(0, n, a);
		
		System.out.println(result);
	}
	
	static boolean part[];
	static long result = Long.MAX_VALUE;
	//それぞれの数字の間にパーティションを入れる処理をDFSで行う。
	//2^20なので間に合う
	static void dfs(int currentDepth, int n, long a[]) {
		if(currentDepth == n - 1) {
			
			long tmpOr = 0;
			Vector<Long> vec = new Vector<Long>();
			
			for(int i = 0; i < n; i++) {
				tmpOr |= a[i];
				
				if(part[i]) {
					vec.add(tmpOr);
					tmpOr = 0;
				}
			}
			
			long ex = vec.get(0);
			for(int i = 1; i < vec.size(); i++) {
				ex ^= vec.get(i);
			}
			
			result = Math.min(result, ex);
			return;
		}
		
		part[currentDepth] = false;
		dfs(currentDepth + 1, n, a);
		part[currentDepth] = true;
		dfs(currentDepth + 1, n, a);
	}

}
