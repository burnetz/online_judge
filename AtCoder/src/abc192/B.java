package abc192;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		for(int i = 0; i < str.length(); i++){
			char tmp = str.charAt(i);

			if((i%2 == 0 && tmp <= 'Z')||(i%2 == 1 && tmp >= 'a')){
//				System.out.println(tmp);
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}

}
