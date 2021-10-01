package arc110;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		//1からnまでの数字がどこにあるかを常に把握する。
		//これをやらないとTLEになる。
		int indexes[] = new int[n + 1];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			indexes[a[i]] = i;
		}
		
		Vector<Integer> vec = new Vector<Integer>();
		//まずはnを一番左に、次にn-1,n-2,,,1を適切な場所までスワップさせる。
		//上記の方法で手数がちょうどn回になればOK。
		for(int i = n; i >= 1; i--) {
			if(a[i - 1] == i) {
				continue;
			}
			int index = indexes[i];
			
			for(int j = index; j < i - 1 ; j++) {
				int tmp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = tmp;
				indexes[a[j]] = j;
				indexes[a[j + 1]] = j + 1;
				//indexよりも後の要素はこのあと移動させることがないので
				//この区間に間違った値がある場合は不可能ということ
				if(j > index && a[j] != j + 1) {
					System.out.println(-1);
					return;
				}
				
				vec.add(j + 1);

			}
			
		}
		
		//スワップの回数はちょうどn-1回でなくてはならない。
		//例えばもともと整列済みの場合等も不可。
		if(vec.size() != n - 1) {
			System.out.println(-1);
			return;
		}
		
		Iterator<Integer> it = vec.iterator();
		StringBuffer sb = new StringBuffer();
		while(it.hasNext()) {
			sb.append(it.next() + "\n");
		}
		
		System.out.print(sb);
	}
}