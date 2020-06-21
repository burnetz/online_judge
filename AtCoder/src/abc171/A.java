package abc171;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		if(str.toLowerCase().equals(str)){
			System.out.println("a");
		}
		else {
			System.out.println("A");
		}
	}

}
