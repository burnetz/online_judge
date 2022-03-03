package abc240;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long sum = 0;
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			
			if(que.isEmpty() || que.getLast().num != a) {
				que.add(new Node(a));
				sum++;
			}
			else {
				que.getLast().count++;
				sum++;
				if(que.getLast().count == a) {
					que.removeLast();
					sum -= a;
				}
			}
			sb.append(sum + "\n");
		}
		
		System.out.print(sb);
	}
}

class Node {
	int num;
	long count = 1;
	
	Node(int num){
		this.num = num;
	}
}