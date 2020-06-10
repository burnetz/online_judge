package arc048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Player[] players = new Player[n];
		Player[] printable = new Player[n];
		
		//同じレートのときには真面目に考えなければならないので
		//予めレート対手の出現回数をmapに残しておく
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			players[i] = new Player(sc.nextInt(), sc.nextInt());
			printable[i] = players[i];
			
			String str = players[i].rate + " " + players[i].hand;
			
			if(map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			}
			else {
				map.put(str, 1);
			}
		}
		
		Arrays.sort(players);
		
		int low[] = new int[n];
		int high[] = new int[n];
		
		//予め自分より低い人数と高い人数を数えておくと楽
		for(int i = 1; i < n; i++) {
			if(players[i - 1].rate < players[i].rate) {
				low[i] = i;
			}
			else {
				low[i] = low[i - 1];
			}
			
			if(players[n - i].rate > players[n - i - 1].rate) {
				high[n - i - 1] = i;
			}
			else {
				high[n - i - 1] = high[n - i];
			}
		}
		
		int winPair[] = {0, 2, 3, 1};
		int losePair[] = {0, 3, 1, 2};
		int drawPair[] = {0, 1, 2, 3};
		
		for(int i = 0; i < n; i++) {
			//winとloseの初期値はlowとhighで計算済み
			int win = low[i];
			int lose = high[i];
			int draw = 0;
			
			String winStr = players[i].rate + " " + winPair[players[i].hand];
			String loseStr = players[i].rate + " " + losePair[players[i].hand];
			String drawStr = players[i].rate + " " + drawPair[players[i].hand];
			
			if(map.containsKey(winStr)){
				win += map.get(winStr);
			}
			if(map.containsKey(loseStr)){
				lose += map.get(loseStr);
			}
			//絶対自分が含まれているので-1
			if(map.containsKey(drawStr)){
				draw += map.get(drawStr) - 1;
			}
			
			players[i].record = win + " " + lose + " " + draw;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(printable[i].record);
		}
	}	
}

class Player implements Comparable<Player> {
	int rate;
	int hand;
	String record;
	
	Player(int rate, int hand){
		this.rate = rate;
		this.hand = hand;
	}

	@Override
	public int compareTo(Player p) {
		// TODO Auto-generated method stub
		return this.rate - p.rate;
	}
}