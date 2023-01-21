package arc145;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		char[] str = sc.next().toCharArray();
		
		//文字列を左半分と右半分として考え、それぞれ左端・右端から1つずつずらして見ていく
		for(int i = 0; i < n/2; i++) {
			//このパターンではそれぞれの前の文字によってどう編集するかが決まる
			if(str[i] == 'A' && str[n - 1 - i] == 'B') {
				if(i >= 1 && str[i - 1] == 'A') {
					str[i] = 'B';
				}
				else if(i >= 1 && str[n - i] == 'B'){
					str[n - 1 - i] = 'A';
				}
				else {
					System.out.println("No");
					return;
				}
			}
			//このパターンではそれぞれの後の文字によってどう編集するかが決まる
			else if(str[i] == 'B' && str[n - 1 - i] == 'A') {
				//文字列がBAはそもそも不可
				if(n == 2) {
					System.out.println("No");
					return;
				}
				else if(i < (n + 1)/2  && str[i + 1] == 'A') {
					str[n - i - 2] = 'A';
					str[n - i - 1] = 'B';
				}
				else if(i < (n + 1)/2) {
					str[i] = 'A';
					str[i + 1] = 'B';
				}
				else {
					System.out.println("No");
					return;
				}
			}
		}
		
		System.out.println("Yes");
	}

}