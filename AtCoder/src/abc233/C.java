package abc233;

import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long x = sc.nextLong();
		
		@SuppressWarnings("unchecked")
		ArrayList<Long>[] lists = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Long>();
			
			int l = sc.nextInt();
			for(int j = 0; j < l; j++) {
				lists[i].add(sc.nextLong());
			}
		}
		
		dfs(lists, 0, n, 1, x);
		
		System.out.println(result);
	}
	
	static int result = 0;
	
	//それぞれの層の選択肢の総積が10^5未満なのでDFSで特に問題なく解ける
	static void dfs(ArrayList<Long>[] lists, int depth, int maxDepth, long current, long goal) {
		if(depth == maxDepth) {
			if(current == goal) {
				result++;
			}
			
			return;
		}
		
		for(int i = 0; i < lists[depth].size(); i++) {
			long tmp = lists[depth].get(i);
			//後半は念の為オーバーフロー対策
			if(tmp * current > goal || tmp * current < current) {
				continue;
			}
			
			dfs(lists, depth + 1, maxDepth, current*tmp, goal);
		}
	}
}