package arc002;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		boolean uru = false;

		if(n % 400 == 0 || (n % 100 != 0 && n % 4 == 0)){
			uru = true;
		}

		if(uru){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
