package abc270;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		if(x < 0) {
			x = -x;
			y = -y;
			z = -z;
		}

		if(y < 0 || y > x) {
			System.out.println(x);
		}
		else  {
			if(z < 0) {
				System.out.println(-z*2 + x);
			}
			else if(z < y) {
				System.out.println(x);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}
 
	