package aising2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count = 0;

		for(int i = 0; i < n; i++){
			int tmp = sc.nextInt();

			if(i%2 == 0 && tmp%2 == 1){
				count++;
			}
		}

		System.out.println(count);
	}

}
