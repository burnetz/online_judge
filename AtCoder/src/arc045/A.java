package arc045;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String str = sc.next();
			
			switch(str) {
			case "Left":
				System.out.print("<");
				break;
			case "Right":
				System.out.print(">");
				break;
			default:
				System.out.print("A");		
			}
			
			if(sc.hasNext()) {
				System.out.print(" ");
			}
		}
		
		System.out.println();
	}
}