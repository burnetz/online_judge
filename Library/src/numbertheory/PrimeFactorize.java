package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class PrimeFactorize {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<Integer>();

		int n2 = n;

		while(true){
			boolean divided = false;

			int limit = (int)Math.sqrt(n2);
			for(int i = 2; i <= limit ; i++){
				if(!pg.isPrime(i)){
					continue;
				}

				if(n2%i == 0){
					n2 /= i;
					list.add(i);
					divided = true;
					break;
				}
			}

			if(!divided){
				list.add(n2);
				break;
			}
		}

		System.out.print(n+":");

		for(int i = 0; i < list.size() ; i++){
			System.out.print(" "+list.get(i));
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