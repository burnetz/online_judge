package arc148;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String input = sc.next();
		char str[] = input.toCharArray();
		
		int firstP = -1;
		
		//最初にpが出てくる位置を探す
		for(int i = 0; i < n; i++) {
			if(str[i] == 'p') {
				firstP = i;
				break;
			}
		}
		
		//pが無いということはdだけでできているので何もしない
		if(firstP < 0) {
			System.out.println(str);
			return;
		}
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add(new String(str));
		
		//実際には全くDPの問題ではない。
		//明らかに最初に見つかったpをdに変えることが必要条件なので
		//あとはどこまでをひっくり返すかを一通り試す。O(N^2)で可能。
		for(int i = firstP; i < n; i++) {
			if(str[i] == 'p') {
				String rev = reverse(str, firstP, i);
				String tmp = input.substring(0, firstP) + ""  + rev + "" + input.substring(i + 1);
				pq.add(tmp);
			}
		}
		
		System.out.println(pq.poll());
    }
	
	static String reverse(char[] str, int begin, int end) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = end; i >= begin; i--) {
			if(str[i] == 'd') {
				sb.append('p');
			}
			else {
				sb.append('d');
			}
		}
		
		return sb.toString();
	}
}