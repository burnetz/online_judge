package abc101;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int sn = 0;
		for(int i = 0; i < str.length(); i++){
			sn += str.charAt(i) - '0';
		}

		System.out.println(Integer.parseInt(str) % sn == 0 ? "Yes" : "No");
	}

}
