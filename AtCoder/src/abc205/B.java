package abc205;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		HashSet<Integer> map = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(map.contains(tmp)) {
				System.out.println("No");
				return;
			}
			
			map.add(tmp);
		}
		
		System.out.println("Yes");
	}

}
