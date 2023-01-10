package abc284;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] array = new String[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = sc.next();
		}
		
		for(int i = n - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}		
}