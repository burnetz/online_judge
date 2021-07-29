package arc115;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int matrix[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		int minA = 0;
		int minB = 0;
		//縦に見たときの差分でa[i]が, 横に見たときの差分でb[i]が決まるので
		//そもそもこれがどの列や行でも一致していないと不可
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				if(matrix[i][j + 1] - matrix[i][j] != matrix[i + 1][j + 1] - matrix[i + 1][j]) {
					System.out.println("No");
					return;
				}
				//チェックのついでにa[],b[]の原型を作る
				b[j + 1] = b[j] + matrix[i][j + 1] - matrix[i][j];
				minB = Math.min(minB, b[j + 1]);
			}
		}
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				if(matrix[i + 1][j] - matrix[i][j] != matrix[i + 1][j + 1] - matrix[i][j + 1]) {
					System.out.println("No");
					return;
				}
			}
			a[i + 1] = a[i] + matrix[i + 1][0] - matrix[i][0];
			minA = Math.min(minA, a[i + 1]);
		}
		
		//非負かつ0,0成分が正しくなるように下駄を履かせて表示
		//なお上記の処理をクリアできた場合は必ず適切に下駄を決められる
		System.out.println("Yes");
		for(int i = 0; i < n; i++) {
			System.out.print(a[i] + matrix[0][0] + minB);
			if(i != n - 1) {
				System.out.print(" ");
			}
			else {
				System.out.println();
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(b[i] - minB);
			if(i != n - 1) {
				System.out.print(" ");
			}
			else {
				System.out.println();
			}
		}
	}
}

