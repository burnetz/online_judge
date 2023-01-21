package abc183;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int gx = sc.nextInt();
		int gy = sc.nextInt();

		double targetX = sx + (double)(gx - sx)*sy/(sy + gy);

		System.out.println(targetX);
	}

}
