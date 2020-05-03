package abc165;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();

		long m = 100;

		int i = 0;
		while(true){
			m *= 1.01;

			i++;

			if(m >= x){
				break;
			}
		}

		System.out.println(i);
	}

}
