package abc288;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		for(int i = 0; i < k; i++) {
			pq.add(sc.next());
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
}
