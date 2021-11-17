package abc227;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> set = new HashSet();
		
		for(int i = 1; i <= 1000; i++) {
			for(int j = 1; j <= 1000; j++) {
				set.add(4*i*j + 3*i + 3*j);
			}
		}
		int n = sc.nextInt();
		int result = 0;
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(!set.contains(tmp)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}

