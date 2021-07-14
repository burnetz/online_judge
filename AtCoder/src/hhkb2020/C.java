package hhkb2020;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int p[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		
		boolean used[] = new boolean[200002];
		int currentMin = 0;
		for(int i = 0; i < n; i++) {
			used[p[i]] = true;

			if(currentMin == p[i]) {
				for(int j = currentMin + 1; j <= used.length; j++) {
					if(!used[j]) {
						currentMin = j;
						break;
					}
				}
			}
			System.out.println(currentMin);
		}
	}

}
