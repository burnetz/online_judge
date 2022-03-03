package abc240;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		
		System.out.println(set.size());
	}
}

