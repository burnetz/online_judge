package abc097;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		int result = 1;
		for(int i = 2; i <= x - 1; i++){
			int p = 2;

			while(Math.pow(i, p) <= x){
				result = (int)Math.max(result, Math.pow(i, p));
				p++;
			}
		}

		System.out.println(result);
	}
}
