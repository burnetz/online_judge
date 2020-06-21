package abc171;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		geta = new long[14];
		for(int i = 0; i < geta.length; i++){
			geta[i] = (long)Math.pow(26, i);
			if(i >= 1){
				geta[i] += geta[i - 1];
			}
		}
		int len = 0;
		for(int i = geta.length - 1; i >= 0; i--){
			if(n >= geta[i]){
				len = i + 1;
				break;
			}
		}

		n -= geta[len - 1];

		String result = "";
		while(true){
			result = (char)(n % 26 + 'a') + result;
			n /= 26;

			if(n == 0){
				break;
			}
		}

		//文字数は分かっているので足りないならaでマスクする
		while(result.length() < len){
			result = "a" + result;
		}
		System.out.println(result);
	}

	static long[] geta;
}