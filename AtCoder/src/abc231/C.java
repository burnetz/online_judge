package abc231;

import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		for(int i = 0; i < q; i++) {
			int input = sc.nextInt();
			
			int index = Arrays.binarySearch(a, input);
			
			if(index < 0) {
				index++;
				index *= -1;
			}
			
			System.out.println(n - index);
		}
	}
}