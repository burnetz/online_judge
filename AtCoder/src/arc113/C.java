package arc113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char str[] = sc.next().toCharArray();
		int n = str.length;
		
		long result = 0;
		//各文字の登場回数（i+2文字目から末尾まで。i,i+1文字目は敢えて見ない）
		int count[] = new int[26];
		
		//書き換えの処理をなるべく右側から繰り返し行うのが最適
		//途中で置換元と同じ文字が出れば処理は途切れるが
		//連続する箇所がそこから新しく発生するので右側は全て同じ文字になるはず。
		//途切れる=置換不要として計算する
		for(int i = n - 3; i >= 0; i--) {
			if(str[i] == str[i + 1] && str[i + 1] != str[i + 2]) {
				result += n - i - 2 - count[str[i] - 'a'];
				//右側は全部同一の文字になる
				Arrays.fill(count, 0);
				count[str[i] - 'a'] = n - i - 2;
			}
			else {
				count[str[i + 2] - 'a']++;
			}
		}
		
		System.out.println(result);
	}

}