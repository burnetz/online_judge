package abc061;

import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();

		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		for(int i = 0; i < n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(!map.containsKey(a)){
				map.put(a, (long)b);
			}
			else {
				map.put(a, map.get(a) + b);
			}
		}

		for(int i = 1; i <= 100000; i++){
			if(!map.containsKey(i)){
				continue;
			}
			k -= map.get(i);

			if(k <= 0){
				System.out.println(i);
				break;
			}
		}
	}
}
