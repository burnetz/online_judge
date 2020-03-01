package abc157;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean edit[] = new boolean[n];

		String num = "1";
		if(n == 1){
			num = "0";
		}

		for(int i = 1; i < n; i++){
			num += 0;
		}
		for(int i = 0; i < m; i++){
			int s = sc.nextInt() - 1;
			int c = sc.nextInt();

			if(edit[s] && num.charAt(s) != '0' + c){
				System.out.println(-1);
				return;
			}

			if(n >= 2 && s == 0 && c == 0){
				System.out.println(-1);
				return;
			}
			edit[s] = true;
			num = num.substring(0, s) + c + num.substring(s + 1, n);
		}

		System.out.println(num);
	}

}
