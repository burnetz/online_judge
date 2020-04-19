package arc041;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		
		int result = x;
		
		if(y >= k) {
			result += k;
		}
		else {
			result += y;
			result -= (k - y);
		}
		
		System.out.println(result);
	}
}

