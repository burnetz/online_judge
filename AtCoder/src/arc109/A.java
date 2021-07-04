package arc109;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		int result = 0;

		if(a == b || a - 1 == b){
			result = x;
		}
		else if(a < b){
			result = x;
			result += Math.min(2*x, y) * (b - a);
		}
		else {
			result = x;
			result += Math.min(2*x, y) * (a - b - 1);
		}

		System.out.println(result);
	}
}