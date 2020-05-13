package abc070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] clock = new long[n];
		for(int i = 0; i < n; i++){
			clock[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(clock);
		long result = clock[clock.length - 1];

		for(int i = clock.length - 2; i >= 0; i--){
			if(result % clock[i] != 0){
				result = LCM(result, clock[i]);
			}
		}

		System.out.println(result);
	}

	static long GCDnew (long a, long b){
	    long candidate = a;
	    while (b % a != 0) {
	      candidate = b % a;
	      b = a;
	      a = candidate;
	    }
	    return candidate;
	}
	static long GCD(long a, long b){
		if(b > a){
            long tmpInt = b;
            b = a;
            a = tmpInt;
        }

		long GCD = 1;

        long j = b;
        while(j > 1){
            if(a%j == 0 && b%j == 0){
                GCD *= j;
                a/=j;
                b/=j;
                j = b;
            }
            else {
                j--;
            }
        }

        return GCD;
	}

	static long LCM (long a, long b){
		long GCD = GCDnew(a, b);
		return GCD * (a/GCD) * (b/GCD);
	}
}