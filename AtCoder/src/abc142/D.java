package abc142;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		int p = 2;
		
		//aとbの公約数の中の素数の種類+1が答え
		
		//最低でも1は公約数
		int count = 1;
		
		while(a > 1 && b > 1 && p <= 1_000_000) {
			if(!pg.isPrime(p)) {
				p++;
				continue;
			}
			
			if(a % p == 0 && b % p == 0) {
				count++;
			}
			
			while(a % p == 0) {
				a /= p;
			}
			
			while(b % p == 0) {
				b /= p;
			}
			p++;
		}
		
		//1000000まで試して割れなかったということは巨大な素数ということ
		//この場合a==bなら答えは2、それ以外なら互いに素なので答えは1のまま
		if(a > 1 && b > 1 && a == b) {
			count++;
		}
		
		System.out.println(count);
	}

}

class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[1000001];
 
    public PrimeNumberGenerator() {
        //Date from = new Date();
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
