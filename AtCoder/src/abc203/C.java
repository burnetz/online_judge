package abc203;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextInt();
		
		Friend friends[] = new Friend[n + 1];
		friends[0] = new Friend(0, 0);
		for(int i = 1; i <= n; i++) {
			friends[i] = new Friend(sc.nextLong(), sc.nextLong());
		}
		
		Arrays.sort(friends);
		
		long current = 0;
		for(int i = 1; i <= n; i++) {
//			System.out.println("i = "+i);
			if(k - (friends[i].pos - friends[i - 1].pos) >= 0) {
				current = friends[i].pos;
				k -= friends[i].pos - friends[i - 1].pos;
				k += friends[i].money;
//				System.out.println("at "+current+ " money "+k);
			}
			else {
				current = friends[i - 1].pos + k;
				System.out.println(current);
				return;
			}
		}
		
		System.out.println(current + k);
	}

}

class Friend implements Comparable<Friend>{
	long pos;
	long money;
	
	Friend(long pos, long money){
		this.pos = pos;
		this.money = money;
	}

	@Override
	public int compareTo(Friend f) {
		// TODO Auto-generated method stub
		return this.pos == f.pos ? 0:
			this.pos > f.pos ? 1 : -1;
	}
	
	
}