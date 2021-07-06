package keyence2021;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n];
		long b[] = new long[n];
		
		long amax = 0;
		long bmax = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				// TODO Auto-generated method stub
				return o1 == o2 ? 0 : 
					o1 > o2 ? -1 : 1;
			}
			
		});
		for(int i = 0; i < n; i++) {
			amax = Math.max(amax, a[i]);
			pq.add(b[i]*amax);
			System.out.println(pq.peek());
		}
	}

}
