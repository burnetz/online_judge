package abc247;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String str = "";
		
		for(int i = 1; i <= n; i++) {
			str = str + i + " " + str;
		}
		
		System.out.println(str);
	}
}
