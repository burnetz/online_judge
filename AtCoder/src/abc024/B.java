package abc024;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int result = 0;
		for(int i = 0; i < n; i++){
			if(i == n - 1 || a[i + 1] - a[i] > t){
				result += t;
			}
			else {
				result += a[i + 1] - a[i];
			}
		}

		System.out.println(result);
	}
}