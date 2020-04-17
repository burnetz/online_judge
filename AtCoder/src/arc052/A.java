package arc052;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next().replaceAll("[a-zA-Z]", "");
		System.out.println(str);
	}

}
