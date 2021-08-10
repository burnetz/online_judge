package arc114;

import java.io.IOException;
import java.util.Scanner;


public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x[] = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
		}

		//50までの素数は少ないので全探索で十分間に合う
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};

		long result = Long.MAX_VALUE;
loop:		for(int i = 0; i < Math.pow(2, primes.length) ; i++){
			int tmpI = i;
			long tmpResult = 1;

			for(int j = 0; j < primes.length; j++){
				if(tmpI % 2 == 1){
					tmpResult *= primes[j];
				}
				tmpI /= 2;
			}

			for(int j = 0; j < n; j++){
				boolean coprime = true;
				for(int k = 2; k <= x[j]; k++){
					if(x[j] % k == 0 && tmpResult % k == 0){
						coprime = false;
						break;
					}
				}
				if(coprime){
					continue loop;
				}
			}

			result = Math.min(result, tmpResult);
		}

		System.out.println(result);
	}
}
