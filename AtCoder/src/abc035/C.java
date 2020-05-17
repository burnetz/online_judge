package abc035;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();

		int l[] = new int[n];
		int r[] = new int[n];

		for(int i = 0 ; i < q; i++){
			l[sc.nextInt() - 1]++;
			r[sc.nextInt() - 1]++;
		}

		//左から順に見ていけばi番目が計何区間に属しているかが分かる。その偶奇で結果が分かる
		int current = 0;
		for(int i = 0; i < n; i++){
			current += l[i];
			System.out.print(current%2);
			current -= r[i];
		}
		System.out.println();

	}
}

