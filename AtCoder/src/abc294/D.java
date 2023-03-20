package abc294;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		
		boolean[] done = new boolean[n];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int top = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < q; i++) {
			int type = sc.nextInt();
			
			switch(type) {
			case 1:
				pq.add(top++);
				break;
			case 2:
				int x = sc.nextInt() - 1;
				done[x] = true;
				break;
			default:
				while(done[pq.peek()]) {
					pq.poll();
				}
				sb.append((pq.peek() + 1) + "\n");
			}
		}
		
		System.out.println(sb);
	}
}

