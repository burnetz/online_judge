package abc123;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a[] = new int[5];
		for(int i = 0; i < 5; i++){
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		for(int i = 0; i < 5; i++){
			for(int j = i + 1; j < 5; j++){
				if(a[j] - a[i] > k){
					System.out.println(":(");
					return;
				}
			}
		}

		System.out.println("Yay!");
	}

}
