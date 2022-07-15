package agc049;

import java.util.ArrayDeque;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		
		//変更前文字列のどこに1があったかを記録
		ArrayDeque<Integer> que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			if(s[i] == '1') {
				que.add(i);
			}
		}
		
		//最終的な結果の上限はN^2まではあり得るのでlong
		long result = 0;
		
		//問題の指示から今回可能なのは1を左に送ることと連続する2つの1を0に変えること。
		//文字列を左から順に見て必要に応じて右から1を持ってくることで計算できる。
		for(int i = 0; i < n; i++) {
			//特に使う予定のない1を廃棄するつもりで書いたが
			//ここの処理はもう少しシンプルにできるかも
			if(!que.isEmpty() && que.getFirst() <= i) {
				que.removeFirst();
			}
			if(s[i] != t[i]) {
				//1を持ってくる必要があるのに1がもうない場合
				if(que.isEmpty()) {
					System.out.println(-1);
					return;
				}
				
				//なおどちらの操作を行う場合でも必要な手数は変わらない
				int tmp = que.getFirst();
				s[tmp] = '0';
				que.removeFirst();
				result += tmp - i ;
			}
			
		}
		
		System.out.println(result);
	}
}
