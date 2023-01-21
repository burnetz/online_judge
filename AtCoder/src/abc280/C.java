package abc280;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		
		for(int i = 0; i < t.length; i++) {
			if(i == t.length - 1 || s[i] != t[i]) {
				System.out.println(i + 1);
				return;
			}
		}
	}
}

