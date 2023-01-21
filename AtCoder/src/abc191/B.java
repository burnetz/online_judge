package abc191;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(tmp != x) {
				if(i != 0) {
					System.out.print(" ");
				}
				System.out.print(tmp);
			}
		}
		System.out.println();
	}

}
