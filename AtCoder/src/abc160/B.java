package abc160;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int c1 = x/500;
		x -= c1*500;
		int c2 = x/5;
		
		System.out.println(c1*1000 + c2*5);
	}

}
