package abc228;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int t = sc.nextInt();
		int x = sc.nextInt();
		
		String result = "No";
		if(s < t && s <= x && x < t) {
			result = "Yes";
		}
		if(s > t && !(t <= x && x < s)) {
			result = "Yes";
		}
		
		System.out.println(result);
	}

}
