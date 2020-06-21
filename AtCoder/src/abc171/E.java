package abc171;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int xorAll = 0;
		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			xorAll ^= a[i];
		}

		for(int i = 0; i < n; i++){
			if(i != 0){
				System.out.print(" ");
			}

			System.out.print(xorAll^a[i]);
		}

		System.out.println();
	}

}
