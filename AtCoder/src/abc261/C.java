package abc261;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			if(!map.containsKey(str)) {
				map.put(str, 1);
				System.out.println(str);
			}
			else {
				System.out.println(str + "(" + map.get(str) + ")");
				map.put(str, map.get(str) + 1);
			}
		}
	}
}