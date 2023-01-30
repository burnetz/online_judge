package abc287;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int agree = 0;
		for(int i = 0; i < n; i++) {
			if(sc.next().equals("For")) {
				agree++;
			}
		}
		
		if(agree > n - agree) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}