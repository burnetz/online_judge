package arc068;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count[] = new int[100001];
		
		for(int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}

		//ルールを読み替えると「何度でもカードを2枚捨てることができる」ということ
		//要らないカードの枚数を数える必要がある
		int remain = 0;
		int kind = 0;
		
		for(int i = 1; i < count.length; i++) {
			if(count[i] >= 1) {
				kind++;
				remain += count[i] - 1;
			}
		}
	
		//無駄なく削ることができる
		if(remain % 2 == 0) {
			System.out.println(kind);
		}
		//1種類だけ犠牲になる
		else {
			System.out.println(kind - 1);
		}
	}

}
