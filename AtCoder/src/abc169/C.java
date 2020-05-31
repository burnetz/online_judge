package abc169;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
//		long b = (long)(sc.nextDouble()*100);
//		double b = sc.nextDouble();
		String[] tmpArray = sc.next().split("\\.");
		long b = Integer.parseInt(tmpArray[0])*100 + Integer.parseInt(tmpArray[1]);

		System.out.println(a*b/100);
//		System.out.println((long)(a*b));
	}
}