package arc149;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<LargeNum> pq = new PriorityQueue<LargeNum>();
		
		//数字が9種類、長さが最大mなので全て試しても間に合う
		for(int i = 1; i <= 9; i++) {
			int tmp = 0;
			
			//割り切れるかどうかの判断は実際の数字でなくてもmodで可能。
			//数字の種類と桁数が分かれば後で文字列として復元できる。
			for(int j = 1; j <= n; j++) {
				tmp *= 10;
				tmp += i;
				tmp %= m;
				
				if(tmp == 0) {
					pq.add(new LargeNum(i, j));
				}
			}
		}
		
		if(pq.isEmpty()) {
			System.out.println(-1);
		}
		else {
			LargeNum result = pq.poll();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < result.length; i++) {
				sb.append(result.digit);
			}
			
			System.out.println(sb);
		}
	}

}

//数字の種類と桁数を記録するためのクラス。
//これがあればどんなに大きい数字でもあとで文字列として生成できる。
class LargeNum implements Comparable<LargeNum>{
	int digit;
	int length;
	
	LargeNum(int digit, int length){
		this.digit = digit;
		this.length = length;
	}

	@Override
	public int compareTo(LargeNum l1) {
		// TODO Auto-generated method stub
		return this.length == l1.length ? l1.digit - this.digit : l1.length - this.length;
	}
}