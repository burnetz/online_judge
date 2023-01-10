package abc284;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			long n = sc.nextLong();
			
			long p = -1;
			long q = -1;
			long divisor = 2;
			//素因数分解を試みるが素数を計3回かつ2種類しか使わないのですぐに終わる
			while(true) {
				if(n % divisor == 0) {
					if(n % (divisor*divisor) == 0) {
						p = divisor;
						q = n / (divisor * divisor);
						break;
					}
					else {
						q = divisor;
						p = (long)Math.sqrt(n / divisor);
						break;
					}
				}
				
				divisor++;
			}
			
			System.out.println(p + " " + q);
		}
	}
}