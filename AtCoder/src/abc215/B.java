package abc215;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long num = 1;

		for(int i = 0; i < 100; i++){
			if(num > n){
				System.out.println(i - 1);
				return;
			}
			num *= 2;
		}
	}
}

