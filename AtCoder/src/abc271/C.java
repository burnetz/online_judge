package abc271;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int tmp[] = new int[n];
		for(int i = 0; i < n; i++) {
			tmp[i] = sc.nextInt();
		}
		Arrays.sort(tmp);

		int surplus = 0;

		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		
		//まずは余分に持っている巻を全て売る（絶対に要らないため）
		for(int i = 0; i < n; i++) {
			if(!que.isEmpty() && que.peekLast() == tmp[i]) {
				surplus++;
			}
			else {
				que.add(tmp[i]);
			}
		}
		
		int current = 0;
		//読んでない漫画が手持ちにある、または売ると決めた漫画がある場合は試行
		while(!que.isEmpty() || surplus > 0) {
			//読もうとしていた巻がちょうどある場合はそれを読む
			if(!que.isEmpty() &&  que.peek() == current + 1) {
				que.removeFirst();
				current++;
			}
			else {
				//売る漫画が2冊未満の場合は番号が大きいものを優先的に売る
				while(surplus < 2 && !que.isEmpty()) {
					que.removeLast();
					surplus++;
				}
				//読むべき巻を買う
				if(surplus >= 2) {
					current++;
					surplus -= 2;
				}
				else {
					break;
				}
			}
			
		}
		
		System.out.println(current);
	}
}

