package abc179;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		for(int i = 2; i < n; i++){
			if(a[i - 2] == b[i - 2] && a[i - 1] == b[i - 1] && a[i] == b[i]){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}
}
