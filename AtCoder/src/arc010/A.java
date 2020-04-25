package arc010;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i = 0; i < m; i++){
			if(n <= a){
				n += b;
			}

			int c = sc.nextInt();

			n -= c;

			if(n < 0){
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println("complete");
	}
}
