package arc053;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();

		int n = str.length;
		
		int alpha[] = new int[26];
		for(int i = 0; i < n; i++) {
			alpha[str[i] - 'a']++;
		}
		
		int odd = 0;
		
		//ただし同じアルファベット2文字（例えばaa）で1とする
		int total = 0;
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i]%2 == 1) {
				odd++;
				//奇数の場合は中心となるべき1文字以外に文字のペアがいくつあるか
				total += (alpha[i] - 1)/2;
			}
			//偶数の場合は全てアルファベットのペアとして使える
			else {
				total += alpha[i]/2;
			}
		}
		
		//そもそも奇数個の文字がないなら分割しなくても回分を作れる
		if(odd == 0) {
			System.out.println(n);
		}
		//余った各1文字に対してアルファベットの組を公平に分け与える
		else {
			System.out.println(total/odd*2 + 1);
		}
	}

}
