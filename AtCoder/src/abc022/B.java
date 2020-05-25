package abc022;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();

		int result = 0;
		for(int i = 0; i < n; i++){
			int tmp = sc.nextInt();

			if(set.contains(tmp)){
				result++;
			}

			set.add(tmp);

		}

		System.out.println(result);
	}
}