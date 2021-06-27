package tenka12013quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int num = 42;
		int border = 130_000_001;

		while(true){
			num *= 2;
			if(num >= border){
				System.out.println(num);
				return;
			}
		}

	}

}
