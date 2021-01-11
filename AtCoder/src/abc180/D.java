package abc180;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long count = 0;

		while((y - 1)/x >= a && (a - 1)*x < b){
			x *= a;
			count++;
		}

		count += (y - x - 1)/b;

		System.out.println(count);
	}
}

