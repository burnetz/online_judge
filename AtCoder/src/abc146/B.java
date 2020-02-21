package abc146;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char str[] = sc.next().toCharArray();
		
		for(int i = 0; i < str.length; i++) {
			str[i] = (char)((str[i] - 'A' + n)%26 + 'A');
		}
		System.out.println(str);
	}

}
