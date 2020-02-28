package abc145;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		if(str.substring(0, n/2).equals(str.substring(n/2))) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
