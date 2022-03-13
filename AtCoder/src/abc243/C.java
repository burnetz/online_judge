package abc243;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Person people[] = new Person[n];
		
		for(int i = 0; i < n; i++) {
			people[i] = new Person(sc.nextInt(), sc.nextInt());
		}
		
		String move = sc.next();
		for(int i = 0; i < n; i++) {
			if(move.charAt(i) == 'L') {
				people[i].move = -1;
			}
			else {
				people[i].move = 1;
			}
		}
		
		Arrays.sort(people);
		
		//衝突が起こるのはy座標が同じかつ左の人が右に、右の人が左に移動する場合。
		//ソート済みなら簡単に比較できる。
		for(int i = 0; i < n - 1; i++) {
			if(people[i].y == people[i + 1].y &&
					people[i].move == 1 && people[i + 1].move == -1) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
}

class Person implements Comparable<Person>{
	int x;
	int y;
	int move;
	
	Person(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		return this.y != p.y ? this.y - p.y :
			this.x != p.x ? this.x - p.x : 
				p.move - this.move;
	}
	
	
}