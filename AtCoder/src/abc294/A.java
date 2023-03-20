package abc294;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(tmp%2 == 0) {
				System.out.print(tmp + " ");
			}
		}
	}		
}