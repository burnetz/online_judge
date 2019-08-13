package abc137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0; i < n; i++){
			String str = br.readLine();
			char[] cArray = str.toCharArray();
			Arrays.sort(cArray);
			String sorted = new String(cArray);

			//アナグラムであればソート後は同じ文字列になるはず
			if(!map.containsKey(sorted)){
				map.put(sorted, 1);
			}
			else {
				map.put(sorted, map.get(sorted) + 1);
			}
		}

		Set<String> set = map.keySet();

		Iterator<String> it = set.iterator();

		long result = 0;
		while(it.hasNext()){
			String key = it.next();
			long tmp = map.get(key);

			//nC2
			result += tmp*(tmp - 1)/2;
		}

		System.out.println(result);
	}

}
