package indeednow2015qualb;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();

		if(s.equals(t)){
			System.out.println(0);
			return;
		}
		for(int i = s.length() - 1; i >= 0 ; i--){
			String newStr = s.substring(i) + s.substring(0, i);

//			System.out.println(newStr);

			if(newStr.equals(t)){
				System.out.println(s.length() - i);
				return;
			}
		}

		System.out.println(-1);
	}

}
