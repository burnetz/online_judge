package abc148;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		if(n % 2 == 1) {
			System.out.println(0);
			return;
		}

		//2の個数と5の個数（n!! = 2^(n/2) * (n/2)!）
		long numOfTwo = n / 2;
		long numOfFive = 0;
		
		//n!に含まれる5の個数は5のべき乗で割りまくれば出る
		long fives = 5;
		while(true) {
			long tmp = n / 2 / fives;
			
			if(tmp == 0) {
				break;
			}
			
			numOfFive += tmp;
			fives *= 5;
		}
		
		long twos = 2;
		while(true) {
			long tmp = n / 2 / twos;
			
			if(tmp == 0) {
				break;
			}
			
			numOfTwo += tmp;
			twos *= 2;
		}
		
		System.out.println(Math.min(numOfFive, numOfTwo));
	}

}
