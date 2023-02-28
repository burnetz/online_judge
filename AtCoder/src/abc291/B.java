package abc291;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int a[] = new int[5*n];
		
		for(int i = 0; i < 5*n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		double sum = 0;
		
		for(int i = n; i < 4*n; i++) {
			sum += a[i];
		}
		
		System.out.println(sum / n / 3);
	}
}
