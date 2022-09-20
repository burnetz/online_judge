package abc269;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int left = 1;
		int right = n;
		int top = 1;
		int bottom = n;
		
		//実際には正しい答えは1箇所だけ。
		//ルークが全く置いていない行と列を探す。
		//それぞれO(logN)つまり10回ずつで探せるのでぎりぎり20回で可能
		while(top  < bottom) {
			int mid = (top + bottom)/2;
			System.out.println("? " + top + " " + mid + " " + 1 + " " + n);
			
			int ans = sc.nextInt();
			if(ans == 0) {
				break;
			}
			if(ans < mid - top + 1) {
				bottom = mid;
			}
			else {
				top = mid + 1;
			}
		}
		
		while(left  < right) {
			int mid = (left + right)/2;
			System.out.println("? " + 1 + " " + n + " " + left + " " + mid);
			
			int ans = sc.nextInt();
			
			if(ans == 0) {
				break;
			}
			if(ans < mid - left + 1) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println("! " + top + " " + left);
	}
}