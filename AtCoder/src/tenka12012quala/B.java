package tenka12012quala;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		
		System.out.println(str.replaceAll(" +", ","));
	}
}
