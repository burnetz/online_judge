package abc127;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int left = 1;
		int right = n;
		for(int i = 0; i < m; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();

			//被っている範囲がなければその時点で答えは0
			if(l > right || r < left){
				System.out.println(0);
				return;
			}

			left = Math.max(l, left);
			right = Math.min(r, right);
		}

		System.out.println(right - left + 1);
	}

}
