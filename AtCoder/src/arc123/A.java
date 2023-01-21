package arc123;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long a1 = sc.nextLong();
		long a2 = sc.nextLong();
		long a3 = sc.nextLong();
		
		long sum = 2*a2 - a1 - a3;
		
		long result = 0;
		
		if(sum < 0) {
			result += (-sum + 1)/2;
			sum = (-sum)%2;
		}
		if(sum > 0) {
			result += sum;
		}
		
		System.out.println(result);
	}
}