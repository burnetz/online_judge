package abc044;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String w = sc.next();

		int alpha[] = new int[26];

		for(int i = 0; i < w.length(); i++){
			alpha[w.charAt(i) - 'a']++;
		}

		for(int i = 0; i < 26; i++){
			if(alpha[i] % 2 != 0){
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}
}