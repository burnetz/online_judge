package abc214;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int t = sc.nextInt();

		int count = 0;
		for(int i = 0; i <= s; i++){
			for(int j = 0; j <= s - i; j++){
				for(int k = 0; k <= s - i - j; k++){
					if(i*j*k <= t){
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}
}

