package arc150;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int l = 0; l < t; l++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			char[] str = sc.next().toCharArray();
			
			//[0,i)の区間内の各文字の個数
			int[] ones = new int[n + 1];
			int[] zeros = new int[n + 1];
			int[] wilds = new int[n + 1];
			for(int i = 0; i < n; i++) {
				ones[i + 1] = ones[i];
				zeros[i + 1] = zeros[i];
				wilds[i + 1] = wilds[i];
				
				if(str[i] == '1') {
					ones[i + 1]++;
				}
				else if(str[i] == '0') {
					zeros[i + 1]++;
				}
				else {
					wilds[i + 1]++;
				}
			}
			
			
			int solve = 0;
			
			//長さkの区間内に0がないこと、区間外に1がないことを確認する。
			for(int i = 0; i + k <= n; i++) {
				int rightIndex = i + k;
				int leftOne = ones[i];
				int rightOne = ones[n] - ones[rightIndex];
				
				if(leftOne > 0 || rightOne > 0) {
					continue;
				}
				
				int innerZero = zeros[rightIndex] - zeros[i];
				
				if(innerZero == 0) {
					solve++;
				}
			}
			
			if(solve == 1) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}