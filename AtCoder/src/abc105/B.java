package abc105;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 0; i*4 <= n; i++){
			if((n - i*4) % 7 == 0){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
