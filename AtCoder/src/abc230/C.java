package abc230;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long p = sc.nextLong();
		long q = sc.nextLong();
		long r = sc.nextLong();
		long s = sc.nextLong();
		
		StringBuffer sb = new StringBuffer();
		
		for(long i = p; i <= q; i++) {
			for(long j = r; j <= s; j++) {
				long dx = b - j;
				long dy = a - i;
				
				boolean black = false;
				//判定自体はO(1)で可能。
				//問題にあるkの条件は言い換えると端から端まで塗るという意味なので
				//(i,j),(a,b)間の傾きが1か-1なら塗られると判断できる。
				if(Math.abs(dx) == Math.abs(dy)) {
					black = true;
				}
				
				if(black) {
					sb.append("#");
				}
				else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}