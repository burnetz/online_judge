package jsc2021;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result = 1;
		
		for(int i = 2; i <= b - a + 1; i++) {
			int amod = a % i;
			int x = a;
			
			if(amod != 0) {
				x += i - amod;
			}
			
//			System.out.println(x);
			
			if(x + i <= b) {
				result = i;
			}
		}
		
		System.out.println(result);
	}

}
