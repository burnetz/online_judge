package arc007;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String[] strArray = sc.next().split(x, -1);

		for(int i = 0; i < strArray.length; i++){
			System.out.print(strArray[i]);
		}
		System.out.println();
	}
}
