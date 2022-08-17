package abc264;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		
		if(r >= 8) {
			r = 14 - r;
		}
		if(c >= r && 14 - c >= r) {
			System.out.println(r % 2 == 0 ? "black" : "white");
		}
		else {
			System.out.println(c % 2 == 0 ? "black" : "white");
		}
	}
}
 
	