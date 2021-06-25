package jsc2021;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < n + m; i++) {
			pq.add(sc.nextInt());
		}
		
		boolean first = true;
		while(!pq.isEmpty()) {
			int tmp = pq.remove();
			
			if(!pq.isEmpty() && tmp == pq.peek()) {
				pq.remove();
				continue;
			}
			if(!first) {
				System.out.print(" ");
			}
			else {
				first = false;
			}
			System.out.print(tmp);
		}
		System.out.println();
	}

}
