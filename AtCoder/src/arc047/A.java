package arc047;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		char[] str = sc.next().toCharArray();
		
		int crush = 0;
		int tab = 1;
		
		for(int i = 0; i < n; i++) {
			if(str[i] == '+') {
				tab++;
				if(tab > l) {
					crush++;
					tab = 1;
				}
			}
			else {
				tab--;
			}
		}
		
		System.out.println(crush);
	}
}