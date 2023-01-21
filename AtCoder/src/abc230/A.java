package abc230;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		if(n >= 42) {
			n++;
		}
		System.out.printf("AGC%03d\n", n);
	}

}
