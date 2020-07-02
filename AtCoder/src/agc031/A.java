package agc031;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		int alpha[][] = new int[n][26];

		//i番目より右にそれぞれのアルファベットが何回現れるかをメモる
		for(int i = n - 2; i >= 0; i--){
			for(int j = 0; j < 26; j++){
				alpha[i][j] = alpha[i + 1][j];
			}

			alpha[i][str[i + 1] - 'a']++;
		}

		long result = 0;
		int mod = 1_000_000_007;
		//i番目の文字を基準とし、それと違う文字が右側に何回出てくるかを掛け続ければよい
		for(int i = 0; i < n; i++){
			long tmp = 1;

			for(int j = 0; j < 26; j++){
				if(alpha[i][j] == 0 || j == str[i] - 'a'){
					continue;
				}

				//使わないこともできるので1足しておく
				tmp *= (alpha[i][j] + 1);
				tmp %= mod;
			}

			result += tmp;
			result %= mod;
		}

		System.out.println(result);
	}
}
