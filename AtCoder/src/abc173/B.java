package abc173;

import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("AC", 0);
		map.put("WA", 0);
		map.put("TLE", 0);
		map.put("RE", 0);
		
		for(int i = 0; i < n; i++){
			String str = sc.next();

			if(!map.containsKey(str)){
				map.put(str, 1);
			}
			else {
				map.put(str, map.get(str) + 1);
			}
		}

		System.out.println("AC x "+ map.get("AC"));
		System.out.println("WA x "+ map.get("WA"));
		System.out.println("TLE x "+ map.get("TLE"));
		System.out.println("RE x "+ map.get("RE"));
	}

}
