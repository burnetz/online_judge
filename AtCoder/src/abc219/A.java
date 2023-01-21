package abc219;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		if(x < 40){
			System.out.println(40 - x);
		}
		else if(x < 70){
			System.out.println(70 - x);
		}
		else if(x < 90){
			System.out.println(90 - x);
		}
		else{
			System.out.println("expert");
		}
	}

}
