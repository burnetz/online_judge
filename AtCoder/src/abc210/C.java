package abc210;

import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int c[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < n; i++){
			c[i] = sc.nextInt();
		}

		for(int i = 0; i < k; i++){
			if(map.containsKey(c[i])){
				map.put(c[i], map.get(c[i]) + 1);
			}
			else{
				map.put(c[i], 1);
			}
		}

		int result = map.size();

		for(int i = k; i < n; i++){
			if(map.containsKey(c[i])){
				map.put(c[i], map.get(c[i]) + 1);
			}
			else{
				map.put(c[i], 1);
			}
			if(map.get(c[i - k]) >= 2){
				map.put(c[i - k], map.get(c[i - k]) - 1);
			}
			else{
				map.remove(c[i - k]);
			}
			result = Math.max(result, map.size());
		}
		System.out.println(result);
	}

}
