package arc119;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long result = Long.MAX_VALUE;

		for(int i = 0; i < 63 ; i++){
			long a = 0;
			long b = i;
			long c = 0;

			if(Math.pow(2, i) > n){
				break;
			}

			a = n/(long)Math.pow(2, b);
			c = n%(long)(a*Math.pow(2, b));

			result = Math.min(result, a + b + c);
		}

		System.out.println(result);
	}
}