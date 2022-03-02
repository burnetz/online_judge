package abc239;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
//		for(int i = 1; i <= 30; i++) {
//			System.out.println(isPrime(i));
//		}
		for(int i = a; i <= b ; i++) {
			boolean critical = true;
			
			for(int j = c; j <= d; j++) {
				if(isPrime(i + j)) {
					critical = false;
					break;
				}
			}
			
			if(critical) {
				System.out.println("Takahashi");
				return;
			}
		}
		
		System.out.println("Aoki");
	}
	
	static boolean isPrime(int x) {
		if(x <= 1) {
			return false;
		}
		
		for(int i = 2; i < x; i++) {
			if(x % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}