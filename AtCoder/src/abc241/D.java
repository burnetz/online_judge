package abc241;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();

		//挿入のたびにソートするわけにはいかないのでTreeMapを使う。
		//x以上またはx以下のビューの取得も容易
		TreeMap<Long, Integer> set = new TreeMap<Long, Integer>();

		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			long x = sc.nextLong();

			switch (mode) {
			case 1: {
				addToMap(set, x);
				break;
			}
			case 2: {
				int k = sc.nextInt();

				//ここでは一旦大小を反転させる。
				//もしheadMapを使うとk<=5の制約が活かせない。
				SortedMap<Long, Integer> lower = set.descendingMap().tailMap(x);
				
				if(lower == null) {
					System.out.println(-1);
				}
				else {
					Iterator<Long> it = lower.keySet().iterator();
					
					int tmpCount = 0;
					while(it.hasNext()) {
						long tmp = it.next();
						tmpCount += set.get(tmp);
						
						if(tmpCount >= k) {
							System.out.println(tmp);
							break;
						}
					}
					
					if(tmpCount < k) {
						System.out.println(-1);
					}
				}
				
				break;
			}
			case 3: {
				int k = sc.nextInt();

				SortedMap<Long, Integer> upper = set.tailMap(x);
				
				if(upper == null) {
					System.out.println(-1);
				}
				else {
					Iterator<Long> it = upper.keySet().iterator();
					
					int tmpCount = 0;
					while(it.hasNext()) {
						long tmp = it.next();
						tmpCount += set.get(tmp);
						
						if(tmpCount >= k) {
							System.out.println(tmp);
							break;
						}
					}
					
					if(tmpCount < k) {
						System.out.println(-1);
					}
				}
				break;
			}
			}
		}
	}
	
	static void addToMap(Map<Long, Integer> map, long x) {
		if(!map.containsKey(x)) {
			map.put(x, 1);
		}
		else {
			map.put(x, map.get(x) + 1);
		}
	}
}

