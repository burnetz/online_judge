package abc154;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if(set.contains(tmp)) {
				System.out.println("NO");
				return;
			}
			set.add(tmp);
		}
		
		System.out.println("YES");
	}

}
