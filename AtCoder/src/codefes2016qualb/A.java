package codefes2016qualb;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String rightStr = "CODEFESTIVAL2016";
		String str = sc.next();

		int count = 0;

		for(int i = 0; i < 16; i++){
			if(str.charAt(i) != rightStr.charAt(i))count++;
		}

		System.out.println(count);
	}

}
