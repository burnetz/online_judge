package abc150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		checked = new boolean[n + 1];
		
		calcIndex(0, 1, n);
		
		String[] tmpArray = br.readLine().split(" ");
		
		int p = 0;
		int q = 0;
		
		for(int i = 0; i < n; i++) {
			p += Integer.parseInt(tmpArray[i]);
			p *= 10;
		}
		p /= 10;

		tmpArray = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			q += Integer.parseInt(tmpArray[i]);
			q *= 10;
		}
		q /= 10;
		
		System.out.println(Math.abs(map.get(p) - map.get(q)));
	}
	
	static boolean checked[];
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int index = 0;

	//全探索でそれぞれの数字に番号を割り振る
	static void calcIndex(int num, int depth, int n) {
		if(depth == n + 1) {
			map.put(num, index);
			index++;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!checked[i]) {
				checked[i] = true;
				calcIndex(num*10 + i, depth + 1, n);
				checked[i] = false;
			}
		}
	}

}
