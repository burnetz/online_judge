package abc254;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a[] = new int[n];
		int copy[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			copy[i] = a[i];
		}
		
		Arrays.sort(copy);

		//相互にスワップが可能な集合を1グループとすると
		//全部でkグループが存在する。
		@SuppressWarnings("unchecked")
		Vector<Integer>[] vecs = new Vector[k];
		for(int i = 0; i < k; i++) {
			vecs[i] = new Vector<Integer>();
		}
		
		for(int i = 0; i < n; i++) {
			vecs[i%k].add(a[i]);
		}
		
		for(int i = 0; i < k; i++) {
			Collections.sort(vecs[i]);
		}
		
		//もし条件を満たすことができるなら
		//グループごとにソートして再構成したものと
		//もともとの配列をソートしたものが一致するはず。
		//kが大きいときはグループのサイズが小さくなるので一応間に合う。
		for(int i = 0; i < n; i++) {
			if(copy[i] != vecs[i%k].get(i/k)) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}
