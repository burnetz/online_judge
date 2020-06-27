package abc172;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();

		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != t.charAt(i)){
				count++;
			}
		}

		System.out.println(count);
	}

}
