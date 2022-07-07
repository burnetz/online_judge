package abc251;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int count = 0;
		//L
		if(c >= 2) {
			count++;
		}
		//R
		if(c < w) {
			count++;
		}
		//U
		if(r >= 2) {
			count++;
		}
		//D
		if(r < h) {
			count++;
		}
		
		System.out.println(count);
	}		
}

