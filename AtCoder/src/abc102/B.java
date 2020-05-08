package abc102;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int result = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				result = Math.max(result, Math.abs(a[i] - a[j]));
			}
		}

		System.out.println(result);
	}

}
