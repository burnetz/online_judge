package abc008;

import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String maxName = null;
		for(int i = 0; i < n; i++){
			String name = sc.next();

			if(!map.containsKey(name)){
				map.put(name, 1);
			}
			else {
				map.put(name, map.get(name) + 1);
			}

			if(maxName == null || map.get(maxName) < map.get(name)){
				maxName = name;
			}
		}

		System.out.println(maxName);
	}
}