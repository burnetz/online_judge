package vol12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CallingExtraterrestrial {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrimeNumberGenerator pg = new PrimeNumberGenerator();

		while(true){
			String[] tmpArray = br.readLine().split(" ");

			int m = Integer.parseInt(tmpArray[0]);
			int a = Integer.parseInt(tmpArray[1]);
			int b = Integer.parseInt(tmpArray[2]);

			if(m == 0){
				break;
			}

			int maxArea = 0;
			int maxI = 0, maxJ = 0;
			//ちゃんと途中でやめないとオーバーフローが発生する
			for(int i = 2; i <= Math.sqrt(m); i++){
				if(!pg.isPrime(i)){
					continue;
				}
				for(int j = i; i*j <= m; j++){
					if(!pg.isPrime(j)){
						continue;
					}

					//分数よりも掛け算の比較の方が多分誤差が少ない
					if(a*j <= b*i && i*j > maxArea){
						maxI = i;
						maxJ = j;
						maxArea = i*j;
					}
				}
			}

			System.out.println(maxI+" "+maxJ);
		}
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
