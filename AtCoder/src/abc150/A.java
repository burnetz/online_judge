package abc150;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		if(k*500 >= x) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
