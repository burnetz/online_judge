package agc003;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		char[] alpha = new char[128];
		for(int i = 0; i < str.length(); i++){
			alpha[str.charAt(i)]++;
		}

		if((alpha['N'] != 0 && alpha['S'] == 0) || (alpha['S'] != 0 && alpha['N'] == 0) || (alpha['E'] != 0 && alpha['W'] == 0) ||(alpha['W'] != 0 && alpha['E'] == 0)){
			System.out.println("No");
		}
		else{
			System.out.println("Yes");
		}
	}

}
