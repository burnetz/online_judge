package abc009;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		for(int i = n - 2; i >= 0; i--){
			if(a[i] != a[n - 1]){
				System.out.println(a[i]);
				return;
			}
		}
	}
}