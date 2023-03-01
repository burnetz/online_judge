package arc156;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			char[] str = sc.next().toCharArray();
			
			int count = 0;
			int first = -1;
			int last = n;
			for(int j = 0; j < n; j++) {
				if(str[j] == '1') {
					if(first < 0) {
						first = j;
					}
					last = j;
					count++;
				}
			}
			int result = 0;
			//操作によって偶奇は変わらないので1が奇数個のときは不可能
			if(count % 2 == 1) {
				result = -1;
			}
			//1が偶数個かつ4以上なら必ず余分なスワップ無しで2個ずつ0にできる。
			//また1が0個なら当然0回でできる。
			else if(count != 2) {
				result = count/2;
			}
			//ここから先は1の個数がちょうど2個という前提
			
			//2個の1が連続している場合
			else if(first + 1 == last) {
				//110, 011が該当するがどちらも不可能
				if(n == 3) {
					result = -1;
				}
				//0110の場合 0110 -> 1111 -> 0101 -> 0000のように3回必要。他の順番で変えても2回以下では不可能
				else if(n == 4 && first == 1) {
					result = 3;
				}
				//ここから先は入れ替えのための十分なスペースがあるパターン。
				//いずれかの1を一旦遠くに移動させるのに1回、2個同時に消すのに1回で計2回。
				else {
					result = 2;
				}
			}
			//2個かつ連続していないなら1回で消せる
			else {
				result = 1;
			}
			
			System.out.println(result);
		}
	}
}