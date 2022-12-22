package abc282;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		
		boolean in = false;
		
		for(int i = 0; i < n; i++) {
			switch (s[i]) {
			case '"': 
				in = !in;
				break;
			
			case ',':
				if(!in) {
					s[i] = '.';
				}
			}
		}
		
		System.out.println(s);
	}
}

