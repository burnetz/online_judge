package abc228;

import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int input[][] = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		int count[] = new int[1201];
		
		for(int i = 0; i < n; i++) {
			int tmp = 0;
			for(int j = 0; j < 3; j++) {
				tmp += input[i][j];
			}
			count[tmp]++;
		}
		
		for(int i = 0; i < n; i++) {
			int tmpSum = 0;
			for(int j = input[i][0] + input[i][1] + input[i][2] + 301; 
					j <= 1200 ; j++) {
				tmpSum += count[j];
			}
//			System.out.println(tmpSum);
			if(tmpSum <= k - 1) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}