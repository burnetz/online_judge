package abc295;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		int result = 0;
		for(int i = 0; i < n - 1; i++) {
			if(a[i] == a[i + 1]) {
				result++;
				i++;
			}
		}
		
		System.out.println(result);
	}
}