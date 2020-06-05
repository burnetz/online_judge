package arc014;

import java.util.ArrayDeque;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();

		ArrayDeque<Character> queue = new ArrayDeque<Character>();
		
		queue.add(str.charAt(0));
		
		for(int i = 1; i < n; i++) {
			char tmp = str.charAt(i);
			
			if(queue.isEmpty()) {
				queue.add(tmp);
			}
			//今消せるなら後に残す意味が全くないので消えるように入れる
			else if(queue.getFirst() == tmp) {
				queue.removeFirst();
			}
			else if(queue.getLast() == tmp) {
				queue.removeLast();
			}
			//上記に該当せず、最後の球であるか次の球と同じ色ならどっちに入れてもいい
			else if(i == n - 1 || str.charAt(i + 1) == tmp) {
				queue.addFirst(tmp);
			}
			//それ以外のときは次の球を邪魔しない方向から入れる
			else if(str.charAt(i + 1) == queue.getFirst()) {
				queue.addLast(tmp);
			}
			else {
				queue.addFirst(tmp);
			}
		}
		
		System.out.println(queue.size());
	}
}
