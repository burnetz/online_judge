package abc236;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char str[] = sc.next().toCharArray();
		int a = sc.nextInt() - 1;
		int b = sc.nextInt() - 1;
		
		char tmp = str[a];
		str[a] = str[b];
		str[b] = tmp;
		
		System.out.println(str);
	}
}
