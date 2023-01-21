package hitachi2020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		switch(str) {
		case "hi" :
		case "hihi" :
		case "hihihi" :
		case "hihihihi" :
		case "hihihihihi" :
			System.out.println("Yes");
			break;
		default: 
			System.out.println("No");	
		}
	}

}
