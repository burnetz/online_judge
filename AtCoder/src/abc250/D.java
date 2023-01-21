package abc250;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		
		Vector<Integer> vec = new Vector<Integer>();
		for(int i = 2; i <= 1_000_000 ; i++) {
			if(pg.isPrime(i)) {
				vec.add(i);
			}
		}
		
		long sum = 0;
		int upperIndex = vec.size() - 1;
		
		//pが増加するときqの上限は単調減少するので
		//全てをカウントしなくてもパターン数の計算は可能
		for(int i = 0; i < vec.size(); i++) {
			int tmp = -1;
			for(int j = upperIndex; j > i; j--) {
				//普通にp*q^3を試そうとすると多分オーバーフローする
				if(n / Math.pow(vec.elementAt(j), 3) >= vec.elementAt(i)) {
					tmp = j;
					upperIndex = j;
					break;
				}
			}
			
			if(tmp > 0) {
				sum += tmp - i;
			}
			else {
				break;
			}
		}
		
		System.out.println(sum);
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