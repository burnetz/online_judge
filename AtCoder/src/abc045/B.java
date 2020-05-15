package abc045;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		@SuppressWarnings("unchecked")
		Queue<Integer>[] queue = new Queue[3];
		queue[0] = new ArrayDeque<Integer>();
		queue[1] = new ArrayDeque<Integer>();
		queue[2] = new ArrayDeque<Integer>();

		for(int i = 0; i < 3; i++){
			String str = sc.next();
			for(int j = 0; j < str.length(); j++){
				queue[i].add(str.charAt(j) - 'a');
			}

		}

		int player = 0;
		while(queue[player].size() != 0){
			player = queue[player].poll();
		}

		System.out.println((char)(player + 'A'));
	}
}