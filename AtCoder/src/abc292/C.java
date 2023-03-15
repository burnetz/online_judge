package abc292;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		//pattern[i] : i = abとなる自然数a,bのパターン数
		long pattern[] = new long[n];
		pattern[1] = 1;
		for(int i = 2; i < n; i++) {
			//素数ならパターン数は必ず2
			if(pg.isPrime(i)) {
				pattern[i] = 2;
			}
			//素因数分解でパターン数を求める
			else {
				int tmpNum = i;
				int divisor = 2;
				int divCount = 0;
				int tmpResult = 1;
				while(true) {
					while(tmpNum % divisor == 0) {
						tmpNum /= divisor;
						divCount++;
					}
					tmpResult *= divCount + 1;
					divisor++;
					divCount = 0;

					if(tmpNum == 1) {
						break;
					}
					//途中で素数になった場合の処理を作ることで高速化できる。
					//これが無いと大きな素数を含む合成数でTLEになる。
					if(pg.isPrime(tmpNum)) {
						tmpResult *= 2;
						break;
					}
				}
				
				pattern[i] = tmpResult;
			}
		}
		
		long result = 0;
		for(int i = 1; i < n; i++) {
			result += pattern[i] * pattern[n - i];
		}
		System.out.println(result);
	}
}

class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[200001];

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