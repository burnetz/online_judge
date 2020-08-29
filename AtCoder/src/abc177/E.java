package abc177;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		int n = sc.nextInt();
		int a[] = new int[n];
		int a2[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			a2[i] = a[i];
		}

		int count[] = new int[1_000_001];
		boolean pc = true;
		//a[i]の約数がa[i - 1]までで一度も登場しないならpariwise
		for(int i = 0; i < n; i++){
			if(pg.isPrime(a[i])){
				if(count[a[i]] > 0){
					pc = false;
					break;
				}
				else {
					count[a[i]]++;
				}
			}

			else {
				int div = 2;
				boolean firstCheck = true;
				while(a[i] > 1){
					if(a[i] % div == 0){
						if(firstCheck && count[div] > 0){
							pc = false;
							break;
						}
						else {
							a[i] /= div;
							count[div]++;
							firstCheck = false;
						}
					}
					else {
						div++;
						firstCheck = true;
					}
				}

				if(!pc){
					break;
				}
			}
		}

		if(pc) {
			System.out.println("pairwise coprime");
			return;
		}

		int result = a2[0];
		//setwiseは素直にGCDを繰り返せばよい
		for(int i = 1; i < n; i++){
			result = gcd(a2[i], result);
		}

		if(result == 1){
			System.out.println("setwise coprime");
		}
		else {
			System.out.println("not coprime");
		}
	}

	static int gcd(int a, int b){
        int tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}

class PrimeNumberGenerator {
    private final int N = 1000000;
    private boolean[] isPrime= new boolean[N + 1];

    public PrimeNumberGenerator() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int limit = (int)Math.sqrt(N);
        for(int i = 2; i <= limit ; i++){

            if(isPrime[i] == false){
                continue;
            }

            for(int j = i * 2; j <= N; j += i){
                isPrime[j] = false;
            }
        }
    }

    public boolean isPrime(int index){
        return isPrime[index];
    }
}