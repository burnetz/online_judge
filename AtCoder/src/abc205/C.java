package abc205;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();

		if(a == b){
			System.out.println("=");
		}
		else if(c%2 == 1 && a*b < 0){
			if(a < 0){
				System.out.println("<");
			}
			else {
				System.out.println(">");
			}
		}
		else if(c%2 == 1 && a <= 0 && b <= 0){
			if(a == 0 || a < b){
				System.out.println(">");

			}
			else {
				System.out.println("<");
			}

		}
		else {
			if(Math.abs(a) == Math.abs(b)){
				System.out.println("=");
			}
			else if(Math.abs(a) > Math.abs(b)){
				System.out.println(">");
			}
			else {
				System.out.println("<");
			}
		}

	}

}
