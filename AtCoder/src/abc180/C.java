package abc180;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(long i = 1; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				pq.add(i);
				if(i != Math.sqrt(n)){
					pq.add(n / i);
				}
			}
		}

		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}
}