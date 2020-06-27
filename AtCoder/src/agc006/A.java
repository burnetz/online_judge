package agc006;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();
		String t = sc.next();

		for(int i = n; i >= 0; i--){
			if(s.substring(n - i).equals(t.substring(0, i))){
				System.out.println(2*n - i);
				return;
			}
		}
	}
}
