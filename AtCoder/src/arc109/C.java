package arc109;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		str = sc.next();
		
		//memo[i][j] : i文字目から2^j文字分の勝負の結果
		//愚直に再帰をすると処理が終わらないが
		//勝負のパターン自体が10000程度しかないのでメモしておくことが有効
		memo = new char[200][200];
		
		char result = winner(0, k);
		
		System.out.println(result);
	}
	
	static String str;
	static char memo[][];
	
	//基本的には再帰で普通に勝負をさせる。
	//ただし既に結果を知っている勝負は即終了する。
	static char winner(int begin, int pow) {
		if(memo[begin][pow] != 0) {
			return memo[begin][pow];
		}
		int mod = str.length();
		
		if(pow == 0) {
			memo[begin][pow] = str.charAt(begin);
		}
		else {
			char win1 = winner(begin, pow - 1);
			char win2 = winner((begin + (int)repeatablePow(2, pow - 1, mod))%mod, pow - 1);

			memo[begin][pow] = fight(win1, win2);
		}
		
		return memo[begin][pow];
	}
	
	static char fight(char c1, char c2) {
		if((c1 == 'R' && c2 == 'S') || (c1 == 'S' && c2 == 'P') || (c1 == 'P' && c2 == 'R')) { 
			return c1;
		}
		else if((c2 == 'R' && c1 == 'S') || (c2 == 'S' && c1 == 'P') || (c2 == 'P' && c1 == 'R')) { 
			return c2;
		}
		else {
			return c1;
		}
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