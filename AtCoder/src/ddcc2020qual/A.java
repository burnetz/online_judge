package ddcc2020qual;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		long sum = 0;

		switch (x) {
		case 1:
		case 2:
		case 3:
			sum += (4 - x)*100000;
			break;

		default:
			break;
		}

		switch (y) {
		case 1:
		case 2:
		case 3:
			sum += (4 - y)*100000;
			break;

		default:
			break;
		}

		if(x*y == 1){
			sum += 400000;
		}

		System.out.println(sum);
	}

}
