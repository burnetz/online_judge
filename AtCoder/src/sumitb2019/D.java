package sumitb2019;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		int left[][] = new int[n][10];
		int right[][] = new int[n][10];

		//パスワードは3桁なのである場所から右と左に0~9までの各数字が何回出てくるのかを記録しておけば
		//生成可能かを1つあたりO(N)で判断できる。
		//パスワードは1000パターンしか存在し得ないので
		//それぞれのパスワードを生成可能かを順に調べれば間に合う。
		for(int i = 1; i < n ; i++){
			for(int j = 0; j <= 9; j++){
				left[i][j] = left[i - 1][j];
				right[n - i - 1][j] = right[n - i][j];
			}
			left[i][str[i - 1] - '0']++;
			right[n - i - 1][str[n - i] - '0']++;
		}

		int result = 0;
		for(int i = 0; i <= 999; i++){
			for(int j = 0; j < n; j++){
				if(str[j] == (char)(i % 100 / 10 + '0') && left[j][i / 100] > 0 && right[j][i % 10] > 0){
					result++;
					break;
				}
			}
		}

		System.out.println(result);
	}

}
