package abc241;

import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if(!map.containsKey(tmp)) {
				map.put(tmp, 1);
			}
			else {
				map.put(tmp, map.get(tmp) + 1);
			}
		}
		
		for(int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			
			if(!map.containsKey(tmp) || map.get(tmp) == 0) {
				System.out.println("No");
				return;
			}
			else {
				map.put(tmp, map.get(tmp) - 1);
			}
		}
		
		System.out.println("Yes");
	}
}

