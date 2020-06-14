package abc170;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int n = sc.nextInt();

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < n; i++){
			set.add(sc.nextInt());
		}

		if(!set.contains(x)){
			System.out.println(x);
			return;
		}

		for(int i = 1; ; i++){
			for(int j = 0; j < 2; j++){
				int tmp = x - i*(int)Math.pow(-1, j);

				if(!set.contains(tmp)){
					System.out.println(tmp);
					return;
				}
			}
		}
	}
}