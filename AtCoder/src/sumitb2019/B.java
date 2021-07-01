package sumitb2019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 1; i <= 50000; i++){
			if((int)(1.08*i) == n){
				System.out.println(i);
				return;
			}
		}

		System.out.println(":(");
	}

}
