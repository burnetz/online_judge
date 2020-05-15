package abc049;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		for(int i = 0; i < h; i++){
			String str = sc.next();

			System.out.println(str + "\n" + str);
		}
    }
}