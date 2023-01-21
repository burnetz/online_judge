package arc132;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r[] = new int[n + 1];
		int c[] = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			r[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= n; i++) {
			c[i] = sc.nextInt();
		}
		
		int q = sc.nextInt();
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < q; i++) {
			int queryR = sc.nextInt();
			int queryC = sc.nextInt();
			
			if(r[queryR] + c[queryC] >= n + 1) {
				result.append("#");
			}
			else {
				result.append(".");
			}
		}
		
		System.out.println(result);
	}
}