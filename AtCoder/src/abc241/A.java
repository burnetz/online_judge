package abc241;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int num = 0;
		int a[] = new int[10];
		for(int i = 0; i <= 9; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 3; i++) {
			num = a[num];
		}
		
		System.out.println(num);
	}
}
