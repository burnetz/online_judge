package abc017;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		str = str.replaceAll("[oku]", "").replaceAll("ch", "");
//		System.out.println(str);
		
		if(str.length() == 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}