package abc152;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		//startEnd[i][j] iで始まりjで終わる数字の個数
		int startEnd[][] = new int[11][11];
		
		for(int i = 1; i <= n; i++) {
			//文字列にしたほうが多分楽（それでも間に合う）
			String str = Integer.toString(i);
			
			int left = str.charAt(0) - '0';
			int right = str.charAt(str.length() - 1) - '0';
			
			startEnd[left][right]++;
		}
		
		long total = 0;
		
		for(int i = 1; i <= n; i++) {
			String str = Integer.toString(i);
			
			int left = str.charAt(0) - '0';
			int right = str.charAt(str.length() - 1) - '0';
			
			total += startEnd[right][left];
			
		}
	
		System.out.println(total);
	}

}
