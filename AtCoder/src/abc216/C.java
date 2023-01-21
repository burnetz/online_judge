package abc216;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		String result = "";
		while(n > 0) {
			if(n % 2 == 1) {
				result = "A" + result;
				n--;
			}
			else {
				result = "B" + result;
				n /= 2;
			}
		}
		
		System.out.println(result);
	}
}
