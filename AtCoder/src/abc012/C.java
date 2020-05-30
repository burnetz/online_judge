package abc012;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int remain = 45*45 - n;

		for(int i = 1; i <= 9; i++){
			for(int j = 1; j <= 9; j++){
				if(i*j == remain){
					System.out.println(i + " x "+j);
				}
			}
		}
	}
}