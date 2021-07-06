package abc206;

import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			}
			else {
				map.put(a[i], 1);
			}
		}

		long result = 0;
		for(int i = 0; i < n; i++) {
			result += n - i - map.get(a[i]);
			map.put(a[i], map.get(a[i]) - 1);
			
//			System.out.println(result);
		}
		
		System.out.println(result);
	}
}
