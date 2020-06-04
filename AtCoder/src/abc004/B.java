package abc004;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = new String[4];
		
		for(int i = 0; i < 4; i++) {
			input[i] = new StringBuffer(sc.nextLine()).reverse().toString();
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.println(input[3 - i]);
		}
	}
}