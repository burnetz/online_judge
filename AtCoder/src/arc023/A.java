package arc023;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);


		int y = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();

		if(m <= 2){
			y--;
			m += 12;
		}

		int y2 = 2014, m2 = 5, d2 = 17;
		System.out.println(days(y2,m2,d2) - days(y,m,d));
	}

	static int days(int y, int m, int d){
		return 365*y + y/4 - y/100 + y/400 + 306*(m + 1)/10 + d - 429;
	}
}
