package abc276;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		PriorityQueue<Integer>[] ques = new PriorityQueue[n];
		
		for(int i = 0; i < n; i++) {
			ques[i] = new PriorityQueue<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			ques[a].add(b);
			ques[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(ques[i].size() + " ");
			
			while(!ques[i].isEmpty()) {
				System.out.print(ques[i].remove() + 1 + " ");
			}
			System.out.println();
		}
	}
}
