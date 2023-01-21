package abc273;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		long n = sc.nextLong();
		int k = sc.nextInt();
		
		long divisor = 10;
		for(int i = 0; i < k; i++) {
			long digit = n % divisor / (divisor / 10);
			
			n = n / divisor * divisor;
			
			if(digit >= 5) {
				n += divisor;
			}
			
			divisor *= 10;
		}
		System.out.println(n);
	}
}
 
	