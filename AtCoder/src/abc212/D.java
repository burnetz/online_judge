package abc212;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		Vector<Long> vec = new Vector<Long>();
		//キューの中身を一括で編集するのは間に合わないので
		//後から入る要素の値を相対的に下げる。
		//どれくらい下げたかを記録しておけば取り出し時に元に戻せる。
		long offset = 0;
		for(int i = 0; i < q; i++) {
			int type = sc.nextInt();
			
			switch (type) {
			case 1:
				int x = sc.nextInt();
				pq.add(x - offset);
				break;
			case 2:
				int y = sc.nextInt();
				offset += y;
				break;
			default:
				vec.add(pq.remove() + offset);
				break;
			}
		}
		
		Iterator<Long> it = vec.iterator();
		StringBuffer sb = new StringBuffer();
		while(it.hasNext()) {
			sb.append(it.next() + "\n");
		}
		System.out.println(sb);
	}

}
