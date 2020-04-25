package arc022;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next().toUpperCase();

		if(str.matches(".*I.*C.*T.*")){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
