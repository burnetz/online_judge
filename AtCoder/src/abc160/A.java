package abc160;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		
		if(str[2]==str[3]&&str[4]==str[5]) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
