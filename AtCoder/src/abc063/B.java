package abc063;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		HashSet<Character> set = new HashSet<Character>();

		for(int i = 0; i < str.length(); i++){
			set.add(str.charAt(i));
		}

		System.out.println(set.size() == str.length() ? "yes" : "no");
	}
}