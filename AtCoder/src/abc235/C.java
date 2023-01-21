package abc235;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		HashMap<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
		
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(map.containsKey(tmp)) {
				map.get(tmp).add(i + 1);
			}
			else {
				Vector<Integer> tmpVec = new Vector<Integer>();
				tmpVec.add(i + 1);
				map.put(tmp, tmpVec);
			}
		}
		
		for(int i = 0; i < q; i++) {
			int x = sc.nextInt();
			int k = sc.nextInt();
			
			Vector<Integer> tmpVec = map.get(x);
			
			if(tmpVec == null || tmpVec.size() < k) {
				System.out.println(-1);
			}
			else {
				System.out.println(tmpVec.get(k - 1));
			}
		}
	}
}
