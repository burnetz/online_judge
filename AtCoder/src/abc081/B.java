package abc081;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			int a = sc.nextInt();

			int count = 0;
			while(a % 2 == 0){
				a /= 2;
				count++;
			}

			result = Math.min(result, count);
		}

		System.out.println(result);
	}
}
