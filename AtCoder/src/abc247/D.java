package abc247;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayDeque<Pack> que = new ArrayDeque<Pack>();
		
		int q = sc.nextInt();
		
		for(int i = 0; i < q; i++) {
			int op = sc.nextInt();
			
			if(op == 1) {
				int x = sc.nextInt();
				int c = sc.nextInt();
				
				que.addLast(new Pack(x, c));
			}
			else {
				long sum = 0;
				int count = sc.nextInt();
				
				while(count > 0) {
					Pack first = que.getFirst();
					int use = Math.min(count, first.amount);
					
					sum += (long)use*first.x;
					first.amount -= use;
					
					if(first.amount == 0) {
						que.removeFirst();
					}
					count -= use;
				}
				
				System.out.println(sum);
			}
		}
	}
}

class Pack {
	int x;
	int amount;
	
	Pack(int x, int amount){
		this.x = x;
		this.amount = amount;
	}
}