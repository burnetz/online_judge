package tenka12019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();
		int k = sc.nextInt();

		for(int i = 0; i < n; i++) {
			if(str[i] != str[k - 1]) {
				System.out.print("*");
			}
			else {
				System.out.print(str[i]);
			}
		}
		
		System.out.println();
	}

}
