package codefes2015qualb;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//論外
		if(n < m) {
			System.out.println("NO");
			return;
		}
		
		int a[] = new int[n];
		int b[] = new int[m];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for(int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		
		Arrays.parallelSort(a);
		Arrays.parallelSort(b);
		
		int roomIndex = 0;
		
		//少人数の予約をなるべく小さい部屋に入れる
loop:		for(int i = 0; i < m; i++) {
			while(roomIndex < n) {
				if(a[roomIndex] >= b[i]) {
					roomIndex++;
					continue loop;
				}
				roomIndex++;
			}
			
			if(roomIndex == n) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
