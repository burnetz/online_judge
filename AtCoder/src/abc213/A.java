package abc213;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i = 0; i <= 255; i++){
			if((a^i) == b){
				System.out.println(i);
				return;
			}
		}
	}

}
