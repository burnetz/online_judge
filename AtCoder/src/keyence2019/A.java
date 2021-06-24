package keyence2019;

import java.util.HashSet;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 4; i++) {
			set.add(sc.nextInt());
		}
		
		if(set.contains(1) && set.contains(9) && set.contains(7) && set.contains(4)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
