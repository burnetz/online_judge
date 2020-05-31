package abc169;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		if(n == 1){
			System.out.println(0);
			return;
		}

		//nが素数かどうか判定
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				isPrime = false;
				break;
			}
		}

		if(isPrime){
			System.out.println(1);
			return;
		}

		PrimeNumberGenerator pg = new PrimeNumberGenerator();

		long result = 0;
		long limit = (long)Math.sqrt(n);
		for(int i = 2; i <= limit ; i++){
			if(!pg.isPrime(i)){
				continue;
			}

			long j = 1;
			while(n % (long)Math.pow(i, j) == 0){
				n /= (long)Math.pow(i, j);
				j++;
				result++;
			}

			while(n % i == 0){
				n /= i;
			}
		}

		//limitよりも巨大な素数が含まれていた可能性がある
		//ただし上記で割れるだけ割ったはずなので1個しかない
		if(n > 1){
			result++;
		}
		System.out.println(result);
	}
}


class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[1000001];

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