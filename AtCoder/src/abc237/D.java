package abc237;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		char[] str = sc.next().toCharArray();
		
		Node head = new Node(-1);
		Node tail = new Node(-1);
		
		Node nodes[] = new Node[n + 1];
		nodes[0] = new Node(0);
		head.next = nodes[0];
		nodes[0].prev = head;
		nodes[0].next = tail;
		tail.prev = nodes[0];
		
		//連結リストを自前で作る。
		//nodes[i]をO(1)常に参照できるようにしておけば全体でもO(N)
		for(int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
			if(str[i - 1] == 'L') {
				nodes[i - 1].prev.next = nodes[i];
				nodes[i].next = nodes[i - 1];
				nodes[i].prev = nodes[i - 1].prev;
				nodes[i - 1].prev = nodes[i];
			}
			else {
				nodes[i].prev = nodes[i - 1];
				nodes[i].next = nodes[i - 1].next;
				nodes[i - 1].next = nodes[i];
			}
			
		}
		
		printList(head, tail);
	}
	
	static void printList(Node head, Node tail) {
		StringBuffer sb = new StringBuffer();
		for(Node node = head.next; node != tail; node = node.next) {
			sb.append(node.data + " ");
		}
		
		System.out.println(sb);
	}
}

class Node {
	int data;
	Node prev = null, next = null;
	
	Node (int data){
		this.data = data;
	}
}
