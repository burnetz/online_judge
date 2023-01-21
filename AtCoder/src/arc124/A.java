package arc124;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long result = 1;
		
		int l[] = new int[k];
		int r[] = new int[k];
		boolean appear[] = new boolean[n];
		
		Arrays.fill(l, -1);
		Arrays.fill(r, n);
		for(int i = 0; i < k; i++) {
			switch (sc.next()) {
			case "L":
				l[i] = sc.nextInt() - 1;
				appear[l[i]] = true;
				break;

			default:
				r[i] = sc.nextInt() - 1;
				appear[r[i]] = true;
				break;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(appear[i]) {
				continue;
			}
			int count = 0;
			for(int j = 0; j < k; j++) {
				if(l[j] <= i && r[j] >= i) {
					count++;
				}
			}
			result *= count;
			result %= 998244353;
		}
		
		System.out.println(result);
	}
}