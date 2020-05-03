package abc165;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i = a; i <= b; i++){
			if(i % k == 0){
				System.out.println("OK");
				return;
			}
		}
		System.out.println("NG");
	}

}
