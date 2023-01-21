package abc188;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long subscC = sc.nextLong();
		
		Event events[] = new Event[2*n + 1];
		
		//開始も終了も別個のイベントとして扱うと後の処理が楽になる。
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			//終了日はあえて1日足しておいたほうが楽。
			events[i*2] = new Event(a, c);
			events[i*2 + 1] = new Event(b + 1, -c);
		}
		//ループの都合上最後にダミーのイベントを入れておくと楽
		events[2*n] = new Event(1_000_000_001, 0);
		
		//イベントの発生日でソート
		Arrays.sort(events);
		long costPerDay = 0;
		int prevEvent = 0;
		long result = 0;
		//日付の異なるイベントに遭遇したところで料金の精算を行う。
		//利用開始も利用停止も同じように扱える。
		for(int i = 0; i < events.length; i++) {
			if(events[i].t != prevEvent) {
				int span = events[i].t - prevEvent;
				result += Math.min(subscC, costPerDay)*span;
				prevEvent = events[i].t;
			}
			
			costPerDay += events[i].cost;
			
		}
		
		System.out.println(result);
	}

}

class Event implements Comparable<Event>{
	int t;
	int cost;

	Event(int t, int cost){
		this.t = t;
		this.cost = cost;
	}
	@Override
	public int compareTo(Event ev) {
		// TODO Auto-generated method stub
		return this.t - ev.t;
	}
	
}