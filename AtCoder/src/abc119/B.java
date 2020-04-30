package abc119;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double total = 0;

		for(int i = 0; i < n; i++){
			double x = sc.nextDouble();
			String u = sc.next();

			if(u.equals("JPY")){
				total += x;
			}
			else {
				total += 380000.0*x;
			}
		}

		System.out.printf("%f\n",total);
	}

}
