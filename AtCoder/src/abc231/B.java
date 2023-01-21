package abc231;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			
			if(map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			}
			else {
				map.put(name, 1);
			}
		}
		
		Iterator<String> it = map.keySet().iterator();
		
		int maxCount = 0;
		String maxName = "";
		
		while(it.hasNext()) {
			String tmp = it.next();
			
			if(map.get(tmp) > maxCount) {
				maxCount = map.get(tmp);
				maxName = tmp;
			}
		}
		
		System.out.println(maxName);
	}
}

