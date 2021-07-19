package arc123;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[][] = new int[3][n];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
			
			Arrays.parallelSort(a[i]);
		}
		
		int count = 0;
		int indexB = 0;
		int indexC = 0;
loop:		for(int i = 0; i < n; i++) {
			for(; indexB < n; indexB++) {
				if(a[0][i] >= a[1][indexB]) {
					continue;
				}
				for(; indexC < n; indexC++) {
					if(a[1][indexB] >= a[2][indexC]) {
						continue;
					}
					else {
						count++;
						
						indexB++;
						indexC++;
						continue loop;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}