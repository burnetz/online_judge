package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Power {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int m = Integer.parseInt(tmpArray[0]);
		int n = Integer.parseInt(tmpArray[1]);
		
		long result = repeatablePow(m, n, 1000000007);
		
		System.out.println(result);
	}
	
	static long repeatablePow(int x, int n, int mod){
		if(n == 0){
			return 1;
		}
		long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
		if(n % 2 == 1){
			result = result*x%mod;
		}
		return result;
	}

}
