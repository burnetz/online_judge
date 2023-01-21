package abc239;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		
		if(x >= 0) {
			System.out.println(x/10);
		}
		else {
			System.out.println(-1 * ((-x + 9)/10));
		}
	}
}

