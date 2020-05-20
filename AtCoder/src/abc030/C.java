package abc030;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int time[] = new int[2];
		time[0] = sc.nextInt();
		time[1] = sc.nextInt();

		//あとで時刻でソートするので混ぜてしまってよい
		Flight flights[] = new Flight[n + m];
		for(int i = 0; i < n + m; i++){
			if(i < n){
				flights[i] = new Flight(0, sc.nextInt());
			}
			else {
				flights[i] = new Flight(1, sc.nextInt());
			}
		}
		Arrays.sort(flights);

		int count = 0;
		int current = 1;
		int nextTime = 0;

		//時刻と空港が条件を満たしていれば片道移動が成立したことになる
		for(int i = 0; i < n + m; i++){
			if(current != flights[i].airport && flights[i].time >= nextTime){
				current = (current + 1)%2;
				nextTime = flights[i].time + time[current];
				count++;
			}
		}

		System.out.println(count/2);

	}
}

class Flight implements Comparable<Flight>{
	int airport;
	int time;

	Flight(int airport, int time){
		this.airport = airport;
		this.time = time;
	}

	@Override
	public int compareTo(Flight f) {
		// TODO 自動生成されたメソッド・スタブ
		return this.time - f.time;
	}
}