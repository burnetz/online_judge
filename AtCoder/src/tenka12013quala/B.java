package tenka12013quala;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < 5; j++) {
				sum += sc.nextInt();
			}
			if(sum < 20) {
				count++;
			}
		}
		
		System.out.println(count);

	}

}
