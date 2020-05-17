package abc168;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String str = sc.next();

		if(k < str.length()){
			str = str.substring(0, k) + "...";
		}

		System.out.println(str);
	}

}
