package agc052;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			//入力は関係ない（左右がコピーであるという事実と文字数だけが問題）
			for(int j = 0; j < 3; j++) {
				sc.next();
			}
			
			StringBuffer sb = new StringBuffer();
			//左半分に0がちょうどn個ある
			for(int j = 0; j < n; j++) {
				sb.append(0);
			}
			//n個目と2n個目の0の間は2n文字分、つまりうち半分は1
			for(int j = 0; j < n; j++) {
				sb.append(1);
			}
			//最後に2n個目の0を追加
			sb.append(0);

			System.out.println(sb);
		}
	}
}
