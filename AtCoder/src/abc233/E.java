package abc233;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		int n = str.length;
		
		int digits[] = new int[600000];

		//ある桁の数字は前の桁との漸化式で表せる。
		for(int i = 0; i < n; i++) {
			int tmp = str[i] - '0';
			digits[digits.length - n + i] = digits[digits.length - n + i - 1] + tmp;
		}
		
		//上記の計算では繰り上がりを考慮していないので下の桁から繰り上がりを行う。
		for(int i = digits.length - 1; i >= 1; i--) {
			if(digits[i] >= 10) {
				digits[i - 1] += digits[i]/10;
				digits[i] %= 10;
			}
		}
		
		boolean nonzero = false;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] != 0) {
				nonzero = true;
			}
			
			if(nonzero) {
				sb.append(digits[i]);
			}
		}
		
		System.out.println(sb);
	}

}
