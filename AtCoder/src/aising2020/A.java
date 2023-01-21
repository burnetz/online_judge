package aising2020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();
		int d = sc.nextInt();
		int count = 0;

		for(int i = l; i <= r; i++){
			if(i % d == 0){
				count++;
			}
		}

		System.out.println(count);
	}

}
