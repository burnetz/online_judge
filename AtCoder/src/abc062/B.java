package abc062;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char border[] = new char[w + 2];
		Arrays.fill(border, '#');

		System.out.println(border);
		for(int i = 0; i < h; i++){
			System.out.println('#'+sc.next()+'#');
		}
		System.out.println(border);
	}
}