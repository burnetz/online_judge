package arc106;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		groupId = new int[n];

		long[] initialValue = new long[n];
		long[] finalValue = new long[n];

		for(int i = 0; i < n; i++){
			initialValue[i] = sc.nextLong();
		}

		for(int i = 0; i < n; i++){
			finalValue[i] = sc.nextLong();
		}

		//同じ木の中でAとBの合計が一致していれば可能なので
		//DFSでグループ分けを行う
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] edges = new ArrayList[n];
		for(int i = 0; i < n; i++){
			edges[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++){
			int c = sc.nextInt() - 1;
			int d = sc.nextInt() - 1;
			edges[c].add(d);
			edges[d].add(c);
		}

		int tmpGid = 1;
		for(int i = 0; i < n; i++){
			if(groupId[i] > 0){
				continue;
			}

			dfs(edges, i, tmpGid);
			tmpGid++;
		}

		long sum[] = new long[tmpGid];

		//グループごとにAとBの和が一致していれば以下のループで和が0になる
		for(int i = 0; i < n; i++){
			sum[groupId[i]] += (initialValue[i] - finalValue[i]);
		}

		for(int i = 1; i < sum.length; i++){
			if(sum[i] != 0){
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");

	}


	static int groupId[];

	static void dfs(ArrayList<Integer>[] edges, int from, int gid){
		groupId[from] = gid;

		Iterator<Integer> it = edges[from].iterator();

		while(it.hasNext()){
			int to = it.next();

			if(groupId[to] == 0){
				dfs(edges, to, gid);
			}
		}
	}
}

