package abc148;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		
		for(int i = 0; i < n; i++) {
			System.out.print(a.charAt(i) +""+ b.charAt(i));
		}
		
		System.out.println();
	}

}
