package abc093;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();

		for(int i = a; i <= b; i++){
			if(i <= a + k - 1 || i >= b - (k - 1)){
				System.out.println(i);
			}
		}

	}
}
