package abc194;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		int sum[] = new int[n + 1];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum[i + 1] = sum[i] + a[i];
		}
		
		long result = 0;
		for(int i = 0; i < n; i++) {
			result += a[i] * a[i];
		}
		result *= n - 1;
		
		long tmpSum = 0;
		for(int i = 1; i < n; i++) {
			tmpSum += (long)a[i]*sum[i];
		}
		
		result -= 2*tmpSum;
		
		System.out.println(result);
	}

}
