package abc146;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long x = sc.nextLong();
		
		long u = 1_000_000_000 + 1;
		long l = 0;
		
		//2分探索で解を最大化する
		while(u - l > 1) {
			long mid = (u + l) / 2;
			int len = Long.toString(mid).length();
			if(a*mid + b*len <= x) {
				l = mid;
			}
			else {
				u = mid;
			}
		}
		
		System.out.println(l);
	}

}
