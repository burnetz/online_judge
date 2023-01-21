package abc215;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		PrimeNumberGenerator pg = new PrimeNumberGenerator();

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//多分いらない
		Arrays.sort(a);

		boolean invalid[] = new boolean[100001];

		for(int i = 0; i < n; i++){
			if(a[i] == 1){
				continue;
			}

			int num = a[i];
			int div = 2;

			//基本的には素因数分解->エラトステネス。
			//ただしnum自体が素数かどうかの判定を常に行わないと間に合わない。
			while(num > 1){
				if(pg.isPrime(num)){

					if(!invalid[num]){
						for(int j = 1; num*j < invalid.length; j++){
							invalid[num*j] = true;
						}
					}
					break;
				}
				while(num % div == 0){
					if(!invalid[div]){
						for(int j = 1; div*j < invalid.length; j++){
							invalid[div*j] = true;
						}
					}
					num /= div;
				}
				div++;
			}

		}

		StringBuffer sb = new StringBuffer();

		int count = 0;
		for(int i = 1; i <= m; i++){
			if(i == 1 || !invalid[i]){
				sb.append(i + "\n");
				count++;
			}
		}

		System.out.println(count);
		System.out.print(sb);
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
