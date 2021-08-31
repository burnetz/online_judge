package abc216;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String s[] = new String[n];
		String t[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			s[i] = sc.next();
			t[i] = sc.next();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(s[i].equals(s[j]) && t[i].equals(t[j])) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}
}

