package diverta2019;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int innerAB = 0;
		int lastA = 0;
		int beginB = 0;
		int bAndA = 0;
		//各文字列の内側に入っているABは順番に関係なくカウントできる。
		//順番に依存するのは末尾のAと先頭のBを結合するパターン。
		//ただしBとAに挟まれた文字列の扱いに注意する必要がある。
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			for(int j = 0; j < str.length() - 1; j++) {
				if(str.charAt(j) == 'A' && str.charAt(j + 1) == 'B') {
					innerAB++;
				}
			}
			
			if(str.charAt(str.length() - 1) == 'A' && str.charAt(0) == 'B') {
				bAndA++;
			}
			
			if(str.charAt(str.length() - 1) == 'A') {
				lastA++;
			}
			
			if(str.charAt(0) == 'B') {
				beginB++;
			}
		}
		
		//BとAで挟まれた文字列の個数は除外しておく
		lastA -= bAndA;
		beginB -= bAndA;
		
		int result = innerAB;
		
		//末尾のAのみ、先頭のBのみの文字列がない場合は
		//A*B,A*B,...,A*Bのように並べる。
		if(lastA == 0 && beginB == 0) {
			if(bAndA >= 2) {
				result += bAndA - 1;
			}
		}
		else  {
			//こちらの場合はB*A型の文字列を
			//任意のA*型もしくは*B型の文字列にすべて結合する。
			//その場合結合した数と同じだけ結果が増え、
			//かつA*型およびB*型の個数は変わらずに済む。
			if(bAndA > 0) {
				result += bAndA;
			}
		}
		
		System.out.println(result + Math.min(lastA, beginB));
	}

}
