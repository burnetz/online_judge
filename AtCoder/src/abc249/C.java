package abc249;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		str = new String[n];
		
		for(int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		
		//文字列の個数が15、長さが26までなので組み合わせを全パターン調べても間に合う
		int result = 0;
		for(int i = 0; i < Math.pow(2, n); i++) {
			int alpha[] = new int[26];
			
			int mask = 1;
			for(int j = 0; j < n; j++, mask <<= 1) {
				if((mask & i) != 0) {
					for(int k = 0; k < str[j].length(); k++) {
						alpha[str[j].charAt(k) - 'a']++;
					}
				}
			}
			
			int count = 0;
			for(int j = 0; j < 26; j++) {
				if(alpha[j] == k) {
					count++;
				}
			}
			
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
	
	static int n;
	static int k;
	static String[] str;
}
