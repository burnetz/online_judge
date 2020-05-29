package abc014;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		int total = 0;
		for(int i = 0; i < n; i++){
			if(x % 2 == 1){
				total += sc.nextInt();
			}
			else {
				sc.nextInt();
			}

			x /= 2;
		}

		System.out.println(total);
	}
}