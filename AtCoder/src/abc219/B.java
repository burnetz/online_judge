package abc219;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str[] = new String[3];

		for(int i = 0; i < 3; i++){
			str[i] = sc.next();
		}

		String t = sc.next();

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < t.length(); i++){
			int index = t.charAt(i) - '0' - 1;

			sb.append(str[index]);
		}

		System.out.println(sb);
	}
}

