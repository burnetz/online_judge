package abc083;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int sumsum = 0;
		for(int i = 1; i <= n; i++){
			String num = Integer.toString(i);

			int sum = 0;
			for(int j = 0; j < num.length(); j++){
				sum += num.charAt(j) - '0';
			}

			if(sum >= a && sum <= b){
				sumsum += i;
			}
		}
		System.out.println(sumsum);

	}
}
