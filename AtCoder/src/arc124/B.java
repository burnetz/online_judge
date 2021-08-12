package arc124;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];

		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			//候補は全部でnパターンで十分（どの並べ方にしてもb[0]をa[i]のどれかとマッチングさせるため）
			int x = a[i]^b[0];

			//xをn個作れるかどうかを考える
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int k = 0; k < n; k++) {
				if(map.containsKey(b[k])) {
					map.put(b[k], map.get(b[k]) + 1);
				}
				else {
					map.put(b[k], 1);
				}
			}
			boolean success = true;
			for(int k = 0; k < n; k++) {
				int tmpB = x^a[k];

				if(!map.containsKey(tmpB)) {
					success = false;
					break;
				}
				else {
					int num = map.get(tmpB);

					if(num == 1) {
						map.remove(tmpB);
					}
					else {
						map.put(tmpB, num - 1);
					}
				}
			}

			if(success) {
				set.add(x);
			}

		}

		ArrayList<Integer> list = new ArrayList<Integer>(set);

		Collections.sort(list);

		Iterator<Integer> it = list.iterator();

		System.out.println(list.size());
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}
}