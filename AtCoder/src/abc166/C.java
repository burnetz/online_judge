package abc166;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Hill hills[] = new Hill[n];

		for(int i = 0; i < n; i++){
			hills[i] = new Hill(sc.nextInt());
		}

		for(int i = 0; i < m; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			hills[a].pq.add(hills[b]);
			hills[b].pq.add(hills[a]);
		}

		int count = 0;
		//あらかじめ接続されている展望台をソートしておけば一番高いところとのみ比較すればよい
		for(int i = 0; i < n; i++){
			if(hills[i].pq.size() == 0 ||  hills[i].h > hills[i].pq.peek().h){
				count++;
			}
		}

		System.out.println(count);
	}
}

class Hill implements Comparable<Hill>{
	int h;
	PriorityQueue<Hill> pq = new PriorityQueue<Hill>();

	Hill(int h){
		this.h = h;
	}

	@Override
	public int compareTo(Hill h1) {
		// TODO 自動生成されたメソッド・スタブ
		return h1.h - this.h;
	}
}