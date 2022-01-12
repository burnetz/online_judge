package abc234;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long k = sc.nextLong();
		
		String binStr = Long.toBinaryString(k);
		
		for(int i = 0; i < binStr.length(); i++) {
			if(binStr.charAt(i) == '1') {
				System.out.print("2");
			}
			else {
				System.out.print("0");
			}
		}
		System.out.println();
	}
}