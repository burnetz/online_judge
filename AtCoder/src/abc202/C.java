package abc202;

import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		int c[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt() - 1;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			int tmp = b[c[i]];
			
			if(map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			}
			else {
				map.put(tmp, 1);
			}
		}
		
		long count = 0;
		for(int i = 0; i < n; i++) {
			if(map.containsKey(a[i])) {
				count += map.get(a[i]);
			}
		}
		
		System.out.println(count);
	}

}
