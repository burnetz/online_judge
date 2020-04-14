package arc071;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] alpha = new int[n][26];
		
		for(int i = 0; i < n; i++) {
			char[] str = sc.next().toCharArray();
			
			for(int j = 0; j < str.length; j++) {
				alpha[i][str[j] - 'a']++;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 26; i++) {
			int maxCount = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++) {
				maxCount = Math.min(maxCount, alpha[j][i]);
			}
			
			for(int j = 0; j < maxCount; j++) {
				sb.append((char)(i + 'a'));
			}
		}
		
		System.out.println(sb);
	}

}
