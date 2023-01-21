package abc199;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			b[i] = sc.nextInt();
		}

		int min = 0;
		int max = 1000;

		for(int i = 0; i < n; i++){
			if(a[i] > min){
				min = a[i];
			}

			if(b[i] < max){
				max = b[i];
			}
		}

		System.out.println(Math.max(0, max - min + 1));
	}
}
