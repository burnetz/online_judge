package abc289;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int next[] = new int[n];
		Arrays.fill(next, -1);
		boolean used[] = new boolean[n];
		
		for(int i = 0; i < m; i++) {
			int tmp = sc.nextInt() - 1;
			
			next[tmp] = tmp + 1;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			if(used[i]) {
				continue;
			}
			
			int index = i;
			stack.add(index);
			while(next[index] != -1) {
				stack.add(next[index]);
				used[next[index]] = true;
				index = next[index];
				
			}
			
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + 1 + " ");
			}
		}
	}
}
