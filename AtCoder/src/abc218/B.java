package abc218;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 26; i++){
			System.out.print((char)(sc.nextInt() - 1 + 'a'));
		}
		System.out.println();
	}
}

