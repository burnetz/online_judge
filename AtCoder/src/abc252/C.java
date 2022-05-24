package abc252;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int slot[][] = new int[n][10];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			for(int j = 0; j < 10; j++) {
				slot[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		//どの数字に揃えるとしても合計時間は大きくないので10パターン試すことができる
		for(int i = 0; i < 10; i++) {
			//各リールで数字iが含まれている位置を保存する。
			//条件を満たす数字の中で最もタイミングが早いものを選び続けるのが最適。
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			//initialize
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 10; k++) {
					if(slot[j][k] == i) {
						pq.add(k);
					}
				}
			}
			
			int t = -1;
			
			while(!pq.isEmpty()) {
				int tmp = pq.remove();
				//直前に取り出した時刻以前のものは更に10秒待たなければいけない。
				if(tmp <= t) {
					pq.add(tmp + 10);
				}
				else {
					t = tmp;
				}
			}
			
			result = Math.min(result, t);
		}
		
		System.out.println(result);
	}
}
