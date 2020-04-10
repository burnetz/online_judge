package abc160;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int p[] = new int[a];
		int q[] = new int[b];
		int r[] = new int[c];
		
		for(int i = 0; i < a; i++) {
			p[i] = sc.nextInt();
		}

		for(int i = 0; i < b; i++) {
			q[i] = sc.nextInt();
		}
		
		for(int i = 0; i < c; i++) {
			r[i] = sc.nextInt();
		}
		
		//comparator書きたくなかったので全部小さい順
		Arrays.sort(p);
		Arrays.sort(q);
		Arrays.sort(r);
		
		long total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		//赤いリンゴも緑のリンゴも普通に食べたことにする
		for(int i = 0; i < x; i++) {
			total += p[a - i - 1];
			pq.add(p[a - i - 1]);
		}

		for(int i = 0; i < y; i++) {
			total += q[b - i - 1];
			pq.add(q[b - i - 1]);
		}

		//現時点でpqには食べたリンゴのおいしさが昇順に格納されている
		//無色のリンゴのほうがおいしいなら合計値を更新する
		//できるだけおいしくないリンゴを最もおいしいリンゴに交換するのが最適
		for(int i = c - 1; i >= 0; i--) {
			if(pq.isEmpty()) {
				break;
			}
			int tmp = pq.remove();
			
			if(r[i] > tmp) {
				total += r[i] - tmp;
			}
		}
		System.out.println(total);
	}

}
