package abc015;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = 0;
		int sum = 0;
		for(int i = 0; i < n; i++){
			int a = sc.nextInt();

			if(a != 0){
				count++;
				sum += a;
			}
		}

		System.out.println((sum + count - 1)/count);
	}
}