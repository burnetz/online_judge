package panasonic2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		if(h == 1 || w == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(((long)h*w + 1)/2);
	}
}
