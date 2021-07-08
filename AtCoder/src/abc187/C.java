package abc187;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			if(str.charAt(0) == '!') {
				String sub = str.substring(1);
				if(set.contains(sub)) {
					System.out.println(sub);
					return;
				}
			}
			else {
				String inv = "!" + str;
				if(set.contains(inv)) {
					System.out.println(str);
					return;
				}
			}
			
			set.add(str);
		}
		
		System.out.println("satisfiable");
	}

}
