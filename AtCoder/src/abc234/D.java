package abc234;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < k - 1; i++) {
			pq.add(sc.nextInt());
		}
		
		//順列なので同じ値は現れないから次に来る数字はk番目より大きいか小さいかのいずれか。
		//常にpq内にk個しか数字が入らないようにすれば常に先頭がk番目
		StringBuffer sb = new StringBuffer();
		for(int i = k - 1; i < n; i++) {
			int tmp = sc.nextInt();
			
			//k個目の入力は必ず追加
			if(i == k - 1) {
				pq.add(tmp);
			}
			else if(pq.peek() < tmp) {
				pq.remove();
				pq.add(tmp);
			}
			sb.append(pq.peek() + "\n");
		}
		System.out.println(sb);
	}

}
