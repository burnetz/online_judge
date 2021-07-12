package abc195;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		int len = Long.toString(n).length();
		
		long result = 0;
		
		for(int i = 3; i < len; i++) {
			int comma = (i - 1) / 3;
			
			result += comma * Math.pow(10, i - 1)*9;
		}
		
		int comma = (len - 1) / 3;
		
		result += comma * (n - (Math.pow(10, len - 1) - 1));
		
		System.out.println(result);
	}

}
