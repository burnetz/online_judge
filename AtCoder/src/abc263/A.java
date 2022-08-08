package abc263;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count[] = new int[14];
		
		for(int i = 0; i < 5; i++) {
			count[sc.nextInt()]++;
		}
 
		boolean two = false;
		boolean three = false;
		
		for(int i = 1; i <= 13; i++) {
			if(count[i] == 2) {
				two = true;
			}
			if(count[i] == 3) {
				three = true;
			}
		}
		if(two && three) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}		
}