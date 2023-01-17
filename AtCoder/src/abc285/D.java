package abc285;

import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String s[] = new String[n];
		String t[] = new String[n];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next();
			t[i] = sc.next();
			map.put(s[i], i);
		}
		//おそらく訪問済みかどうかをチェックしないとO(N^2)になる。
		boolean visited[] = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				continue;
			}
			
			//変更が不可能なのはt[i]==s[j]となるiとjを繋いだときにサイクルが生じる場合。
			//サイクルでさえなければそのグループの最後から順に変更すれば良いので可能。
			int start = i;
			int j = i;
			visited[j] = true;
			while(map.containsKey(t[j])) {
				j = map.get(t[j]);
				if(j == start) {
					System.out.println("No");
					return;
				}
				else {
					visited[j] = true;
				}
			}
		}
		
		System.out.println("Yes");
	}
}