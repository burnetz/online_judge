package abc227;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		
		int result = a;
		for(int i = a; i <= a + k - 1; i++, result++) {
			if(result == n + 1) {
				result = 1;
			}
			
			if(i == a + k - 1) {
				System.out.println(result);
			}
		}
		
	}

}
