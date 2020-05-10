package abc091;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int d[] = {1, -1};
		for(int k = 0; k < 2; k++){
			int n = sc.nextInt();

			for(int i = 0; i < n; i++){
				String tmp = sc.next();

				if(!map.containsKey(tmp)){
					map.put(tmp, d[k]);
				}
				else {
					map.put(tmp, map.get(tmp) + d[k]);
				}
			}
		}

		int sum = 0;
		Iterator<String> it = map.keySet().iterator();

		while(it.hasNext()){
			sum = Math.max(sum, map.get(it.next()));
		}

		System.out.println(sum);

	}
}
