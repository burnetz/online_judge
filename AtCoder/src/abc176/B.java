package abc176;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();

		long sum = 0;
		for(int i = 0; i < str.length; i++){
			sum += str[i] - '0';
		}

		System.out.println(sum % 9 == 0 ? "Yes" : "No");
	}
}
