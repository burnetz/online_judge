package abc042;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();

		String[] array = new String[n];

		for(int i = 0; i < n; i++){
			array[i] = sc.next();
		}

		Arrays.sort(array);

		for(int i = 0; i < n; i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
}