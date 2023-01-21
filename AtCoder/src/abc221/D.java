package abc221;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Event[] events = new Event[2*n];
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//ログインとログアウトを対等に扱うと楽
			events[i*2] = new Event(a, 1);
			events[i*2 + 1] = new Event(a + b, -1);
		}
		
		Arrays.sort(events);
		
		int result[] = new int[n + 1];
		int sum = 0;
		for(int i = 0; i < 2*n; i++) {
			sum += events[i].add;
			
			//一番最後のイベント終了時にはログイン人数は0なのでこの条件で問題ない。
			if(i != 2*n - 1 && events[i].time != events[i + 1].time) {
				result[sum] += events[i + 1].time - events[i].time;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(i > 1) {
				System.out.print(" ");
			}
			System.out.print(result[i]);
		}
		System.out.println();
	}

}

class Event implements Comparable<Event>{
	int time;
	int add;
	
	Event(int time, int add){
		this.time = time;
		this.add = add;
	}

	@Override
	public int compareTo(Event ev) {
		// TODO Auto-generated method stub
		return this.time == ev.time ? this.add - ev.add :
			this.time - ev.time;
	}
}