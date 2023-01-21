package keyence2019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		
		if(input.matches("k[a-z]*eyence") || input.matches("ke[a-z]*yence") ||input.matches("key[a-z]*ence") ||input.matches("keye[a-z]*nce") ||input.matches("keyen[a-z]*ce") ||input.matches("keyenc[a-z]*e") ) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
