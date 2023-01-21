package abc185;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int result = 101;
		for(int i = 0; i < 4; i++){
			result = Math.min(sc.nextInt(), result);
		}
		System.out.println(result);
	}

}
