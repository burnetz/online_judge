package abc083;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt() + sc.nextInt();
		int r = sc.nextInt() + sc.nextInt();

		System.out.println(l > r ? "Left" :
			l < r ? "Right" : "Balanced");
	}

}
