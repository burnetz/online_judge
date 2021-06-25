package caddi2018b;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h0 = sc.nextInt();
		int w0 = sc.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			if(h >= h0 && w >= w0) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
