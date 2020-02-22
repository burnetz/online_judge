package abc152;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String ab = "";
		String ba = "";
		
		for(int i = 0; i < b; i++) {
			ab += a;
		}
		
		for(int i = 0; i < a; i++) {
			ba += b;
		}
		
		if(ab.compareTo(ba) < 0) {
			System.out.println(ab);
		}
		else {
			System.out.println(ba);
		}
	}

}
