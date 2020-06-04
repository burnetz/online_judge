package abc003;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != '@' && t.charAt(i) != '@' && s.charAt(i) != t.charAt(i)){
				System.out.println("You will lose");
				return;
			}

			if(s.charAt(i) == '@' && !"atcoder@".contains("" + t.charAt(i))){
				System.out.println("You will lose");
				return;
			}

			if(t.charAt(i) == '@' && !"atcoder@".contains("" + s.charAt(i))){
				System.out.println("You will lose");
				return;
			}
		}

		System.out.println("You can win");
	}
}