package abc200;

import java.util.HashMap;
import java.util.Scanner;

public class D {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		maps = new HashMap[mod];
		for(int i = 0; i < mod; i++) {
			maps[i] = new HashMap<String, Integer>();
		}
		
		dfs(a, 0, 0, 0, "");
		
		System.out.println("No");
	}
	
	//DFSで色々なパターンを考え、途中の選び方を文字列で記録する。
	//選び方自体は2^Nあるがmod 200で考えているので201個目に辿り着くまでには1組は総和の余りが一致するものが現れる。
	static HashMap<String, Integer>[] maps;
	static final int mod = 200;
	static void dfs(long a[], int depth, long sum, int count, String str) {
		if(depth == a.length) {
			if(count == 0) {
				return;
			}
			int index = (int)(sum % mod);
			maps[index].put(str, count);
			
			if(maps[index].size() == 2) {
				Object[] results = maps[index].keySet().toArray();
				
				System.out.println("Yes");
				
				for(int i = 0; i < 2; i++) {
					String key = (String)results[i];
					System.out.print(maps[index].get(key) + " ");
					System.out.println(key);
				}
				
				System.exit(0);
			}
			return;
		}
		
		dfs(a, depth + 1, sum, count, str);
		dfs(a, depth + 1, sum + a[depth], count + 1, str + (depth + 1) + " ");
	}

}
