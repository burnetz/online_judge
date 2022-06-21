package abc256;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		boolean pos[] = new boolean[4];
		
		int score = 0;
		for(int i = 0; i < n; i++) {
			pos[0] = true;
			
			for(int j = 3; j >= 0; j--) {
				if(pos[j]) {
					pos[j] = false;
					int next = j + a[i];
					
					if(next >= 4) {
						score++;
					}
					else {
						pos[next] = true;
					}
				}
			}
		}
		
		System.out.println(score);
	}
}