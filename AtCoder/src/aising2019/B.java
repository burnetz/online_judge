package aising2019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int count[] = new int[3];

		for(int i = 0; i < n; i++){
			int tmp = sc.nextInt();

			if(tmp <= a){
				count[0]++;
			}
			else if(tmp <= b){
				count[1]++;
			}
			else {
				count[2]++;
			}
		}

		System.out.println(Math.min(count[0], Math.min(count[1], count[2])));
	}

}
