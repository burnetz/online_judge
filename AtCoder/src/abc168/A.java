package abc168;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		switch(n % 10){
		case 2:
		case 4:
		case 5:
		case 7:
		case 9:
			System.out.println("hon");
			break;
		case 0:
		case 1:
		case 6:
		case 8:
			System.out.println("pon");
			break;
		default:
			System.out.println("bon");
		}
	}

}
