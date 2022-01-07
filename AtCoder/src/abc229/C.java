package abc229;

import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		Cheese[] cheese = new Cheese[n];
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			cheese[i] = new Cheese(a, b);
		}
		
		Arrays.sort(cheese);
		
		long result = 0;
		for(int i = 0; i < n && w > 0; i++) {
			long use = Math.min(w, cheese[i].amount);
			result += use * cheese[i].delicious;
			w -= use;
		}
		
		System.out.println(result);
	}
}

class Cheese implements Comparable<Cheese>{
	int delicious;
	int amount;
	
	Cheese (int delicious, int amount){
		this.delicious = delicious;
		this.amount = amount;
	}

	@Override
	public int compareTo(Cheese c) {
		// TODO Auto-generated method stub
		return c.delicious - this.delicious;
	}
}