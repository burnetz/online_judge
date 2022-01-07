package abc233;

import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();
		
		long input[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextLong();
		}
		
		long sum = 0;
		long result = 0;
		//部分列(i,j)はjまでの和とi-1までの和の差で表せる。
		//つまり履歴を残しておけばO(N)で数え上げられる。
		
		//直前までで作れる和と出現回数のペア
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for(int i = 0; i < n; i++) {
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			}
			else {
				map.put(sum, (long)1);
			}
			sum += input[i];
			
			long diff = sum - k;
			
			if(map.containsKey(diff)) {
				result += map.get(diff);
			}
		}
		
		System.out.println(result);
	}

}
