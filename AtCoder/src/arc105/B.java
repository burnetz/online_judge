package arc105;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		long result = a[0];
		
		for(int i = 1; i < n; i++) {
			result = gcd(result, a[i]);
		}
		
		System.out.println(result);
	}
	
	static long gcd(long a, long b){
        long tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}