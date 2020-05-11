package abc084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int q = Integer.parseInt(input);

		PrimeNumberGenerator pg = new PrimeNumberGenerator();

		int similar[] = new int[100000+1];
		for(int i = 1; i < similar.length ; i++){
			similar[i] = similar[i - 1];

			if(pg.isPrime(i) && pg.isPrime((i+1)/2)){
				similar[i] ++;
			}
		}


		for(int i = 0; i < q; i++){
			String[] tmpArray = br.readLine().split(" ");
			int l = Integer.parseInt(tmpArray[0]);
			int r = Integer.parseInt(tmpArray[1]);

			System.out.println(similar[r] - similar[l - 1]);
		}
	}

}

class PrimeNumberGenerator {
    private final int N = 100000;
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