package abc183;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int w = sc.nextInt();

		PriorityQueue<Event> pq = new PriorityQueue<Event>();
		
		//開始も終了もイベントとしてひと括りにして
		//時系列順に処理すればOK
		//同時刻のイベントを水の量でソートすれば
		//先にマイナスの水の量を処理できるので後半のループが簡単になる
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int p = sc.nextInt();
			pq.add(new Event(s, p));
			pq.add(new Event(t, -p));
		}
		
		long currentAmount = 0;
		
		while(!pq.isEmpty()) {
			currentAmount += pq.remove().amount;
			
			if(currentAmount > w) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}

}

class Event implements Comparable<Event>{
	int time;
	int amount;
	
	Event(int time, int amount){
		this.time = time;
		this.amount = amount;
	}

	@Override
	public int compareTo(Event ev) {
		// TODO Auto-generated method stub
		return this.time == ev.time ? this.amount - ev.amount : this.time - ev.time;
	}
}