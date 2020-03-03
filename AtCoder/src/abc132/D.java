package abc132;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]);

		int red = n - k;

		calcCom();

		for(int i = 1; i <= k; i++){
			long result;

			//まずはどこに置くか決める

			result = Com[red + 1][i];

			result = result * Com[k - 1][i - 1] % MOD;

			System.out.println(result);

		}

	}
	static long MOD = 1000000007;
	static int MAX_C = 2002;
	static long[][] Com = new long[MAX_C][MAX_C];

	static void calcCom() {
	    Com[0][0] = 1;
	    for (int i = 1; i < MAX_C; ++i) {
	        Com[i][0] = 1;
	        for (int j = 1; j < MAX_C; ++j) {
	            Com[i][j] = (Com[i-1][j-1] + Com[i-1][j]) % MOD;
	        }
	    }
	}

	static int extGCD(int a, int b, X x, X y){
		System.out.println("a = "+a+" b = "+b);
		int d = a;
		if(b != 0){
			d = extGCD(b, a % b, y, x);
			y.x -= (a/b) *x.x;
		}

		else {
			x.x = 1;
			y.x = 0;
		}

		return d;
	}

	static int modInverse(int a, int m){
		X x = new X(0);
		X y = new X(0);

		extGCD(a, m, x, y);

		System.out.println("x = "+x.x);
		return (m + x.x % m) % m;
	}

	static int[] fact = new int[3000];
	static final int P = 1000000007;

	static int modFact(int n, int p, X e){
		e.x = 0;

		if(n == 0) return 1;

		int res = modFact(n/p, p, e);

		e.x += n/p;

		if(n/p % 2 != 0){
			return res*(p - fact[n % p]) % p;

		}

		return res * fact[n % p] % p;
	}
	static int modComb(int n, int k, int p){
		if(n < 0 || k < 0 || n < k){
			return 0;
		}

		X e1 = new X(0), e2 = new X(0), e3 = new X(0);
		int a1 = modFact(n, p, e1), a2 = modFact(k, p, e2), a3 = modFact(n - k, p, e3);
		System.out.println(a1+" "+a2+" "+a3);
		if(e1.x > e2.x + e3.x){
			return 0;
		}

		return a1 * modInverse(a2*a3%p, p) % p;
	}


}

class X {
	int x;

	X(int x){
		this.x = x;
	}
}

class XY {
	int x;
	int y;

	XY(int x, int y){
		this.x = x;
		this.y = y;
	}
}
