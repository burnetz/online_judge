package abc259;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		
		double rad = Math.PI*d/180;
		double a2 = a*Math.cos(rad) - b*Math.sin(rad);
		double b2 = a*Math.sin(rad) + b*Math.cos(rad);
		
		System.out.println(a2 + " " + b2);
	}
}