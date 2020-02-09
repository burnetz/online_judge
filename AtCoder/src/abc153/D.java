package abc153;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long h = sc.nextLong();
		
		System.out.println((long)Math.pow(2,(int)(Math.log10(h)/Math.log10(2)) + 1) - 1);
	}

}
