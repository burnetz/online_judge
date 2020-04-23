package arc030;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		if(k > n/2){
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}
}
