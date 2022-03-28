package abc245;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean used[] = new boolean[2002];
		
		for(int i = 0; i < n; i++) {
			used[sc.nextInt()] = true;
		}
		
		for(int i = 0; i <= 2001; i++) {
			if(!used[i]) {
				System.out.println(i);
				return;
			}
		}
	}
}