package abc019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next() + "A";

		char prev = str.charAt(0);
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(prev == str.charAt(i)){
				count++;
			}
			else {

				System.out.print("" + prev + count);
				prev = str.charAt(i);
				count = 1;
			}
		}

		System.out.println();
	}
}