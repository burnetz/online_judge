package abc087;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();

		int count = 0;

		for(int i = 0; i <= a; i++){
			for(int j = 0; j <= b; j++){
				for(int k = 0; k <= c; k++){
					if(i*500 + j*100 + k*50 == x){
						count++;
						break;
					}
				}
			}
		}

		System.out.println(count);

	}
}
