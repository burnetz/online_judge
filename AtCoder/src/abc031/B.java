package abc031;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();

		for(int i = 0; i < n; i++){
			int a = sc.nextInt();

			if(a > h){
				System.out.println(-1);
			}
			else {
				System.out.println(Math.max(0, l - a));
			}
		}

	}
}