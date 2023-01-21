package arc115;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		int n = sc.nextInt();
		
		int a[] = new int[n + 1];
		a[1] = 1;
		
		//答えはそれぞれの数字の約数の個数
		//素因数分解で求められる
		for(int i = 2; i <= n; i++) {
			if(pg.isPrime(i)) {
				a[i] = 2;
				continue;
			}
			int num = i;
			int j = 2;
			a[i] = 1;
			while(num > 1) {
				if(num % j == 0) {
					num /= j;
					a[i]++;
				}
				else {
					j++;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(a[i]);
			if(i != n) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[100001];

    public PrimeNumberGenerator() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        int limit = (int)Math.sqrt(isPrime.length);
        for(int i = 3; i <= limit; i+=2){
            if(isPrime[i] == false){
                continue;
            }

            for(int j = i * 2; j <= isPrime.length - 1; j += i){
                isPrime[j] = false;
            }
        }
    }

    public boolean isPrime(int index){
        if(index % 2 == 0 && index != 2){
            return false;
        }
        return isPrime[index];
    }
}