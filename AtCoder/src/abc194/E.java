package abc194;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//登場する数字が高々nまでなので発生・消滅を全数字について把握可能。
		//TreeSetを使えば最小値を高速に取得できる。
		//まずは0〜nまでの数字を全て登録する。
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for(int i = 0; i <= n; i++) {
			tree.add(i);
		}
		
		//区間内の数字の個数を把握するためのmap
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//最初のm個について初期化
		for(int i = 0; i < m; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			}
			else {
				map.put(a[i], 1);
			}
			
			tree.remove(a[i]);
		}
		
		int result = tree.first();
		
		//毎回区間を走査する時間はないので尺取り法で調べる。
		for(int i = m; i < n; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			}
			else {
				map.put(a[i], 1);
			}
			
			tree.remove(a[i]);
			
			if(map.get(a[i - m]) > 1) {
				map.put(a[i - m], map.get(a[i - m]) - 1);
			}
			else {
				map.remove(a[i - m]);
				tree.add(a[i - m]);
			}
			
			result = Math.min(result, tree.first());
		}
		
		System.out.println(result);
	}

}
