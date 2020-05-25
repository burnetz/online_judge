package abc021;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(sc.nextInt());
		set.add(sc.nextInt());

		int k = sc.nextInt();
		for(int i = 0; i < k; i++){
			int tmp = sc.nextInt();

			if(set.contains(tmp)){
				System.out.println("NO");
				return;
			}

			set.add(tmp);

		}

		System.out.println("YES");
	}
}