package exawizards2019;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();
		Arrays.sort(str);

		System.out.println(str[(n - 1)/2] == 'R' ? "Yes" : "No");
	}

}
