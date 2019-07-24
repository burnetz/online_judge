package vol16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkyscraperMinatoHarukas {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer sb = new StringBuffer();

		while(true){
			int n = Integer.parseInt(br.readLine());

			if(n == 0){
				break;
			}

			int m = 0; //m個の数字が連続する
			int a = 0; //aから始まる

			//m*(2a + m - 1) = 2*nを満たすので
			//少なくともmは2*nの約数である必要がある。
			//また、mは個数なのでm(m + 1)/2 <= nの範囲で探索すればよい
			for(int i = calcN(n); i >= 1; i--){
				if(2*n % i == 0){
					int tmp2a = 2*n/i - i + 1;

					//aが自然数である必要がある
					//mが大きい順に探索をしているので条件を満たせば即breakでOK
					if(tmp2a%2 == 0 && tmp2a >= 2){
						m = i;
						a = tmp2a/2;
						break;
					}
				}
			}

			sb.append(a + " " + m+"\n");
		}

		System.out.print(sb);

	}

	//1+2+3+...+n >= sumとなるような最小のnを返す
	static int calcN(long sum){
		return (int) Math.ceil((-1 + Math.sqrt(1 + (double)8*sum))/2);
	}

}
