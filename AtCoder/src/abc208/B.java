package abc208;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();

		int a[] = new int[11];
		a[0] = 1;

		for(int i = 1; i <= 10; i++){
			a[i] = a[i - 1]*i;
		}

		int count = 0;

		for(int i = 10; i >= 1; i--){
			count += p / a[i];
			p %= a[i];
		}

		System.out.println(count);
	}

}
