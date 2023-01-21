package abc261;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int l1 = sc.nextInt();
		int r1 = sc.nextInt();
		int l2 = sc.nextInt();
		int r2 = sc.nextInt();
		
		boolean red[] = new boolean[101];
		boolean blue[] = new boolean[101];
		
		for(int i = l1 ; i <= r1; i++) {
			red[i] = true;
		}
		
		for(int i = l2; i <= r2; i++) {
			blue[i] = true;
		}
		
		int count = 0;
		
		for(int i = 0; i <= 100; i++) {
			if(red[i] && blue[i]) {
				count++;
			}
		}
		System.out.println(Math.max(count - 1, 0));
		
	}		
}

