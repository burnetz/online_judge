package abc253;

import java.util.Scanner;
import java.util.TreeMap;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int q = sc.nextInt();
		
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			
			switch (mode) {
			case 1: 
				int x = sc.nextInt();
				
				if(tmap.containsKey(x)) {
					tmap.put(x, tmap.get(x) + 1);
				}
				else {
					tmap.put(x, 1);
				}
				break;
			case 2: 
				x = sc.nextInt();
				int c = sc.nextInt();
				
				if(tmap.containsKey(x)) {
					tmap.put(x, Math.max(0, tmap.get(x) - c));
					
					if(tmap.get(x) == 0) {
						tmap.remove(x);
					}
				}
				break;
			default:
				System.out.println(tmap.lastKey() - tmap.firstKey());
			}
		}
	}
}
