package abc119;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String strArray[] = sc.next().split("/");

		int y = Integer.parseInt(strArray[0]);
		int m = Integer.parseInt(strArray[1]);
		int d = Integer.parseInt(strArray[2]);

		boolean tbd = false;

		if(m >= 5){
			tbd = true;
		}

		System.out.println(tbd ? "TBD" : "Heisei");
	}

}
