package arc142;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int matrix[][] = new int[n][n];
		
		//上列が全て小さく下列が全て大きく
		//両脇がどちらも大きいかどちらも小さいかを満たすような配置は
		//左から1つ飛ばしに数字を並べ、空いているマスに残りの数字を入れることで作れる。
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < (n + 1)/2; j++) {
				matrix[i][j*2] = i*n + j + 1;
			}
			for(int j = (n + 1)/2 ; j < n; j++) {
				matrix[i][(j - (n + 1)/2)*2 + 1] = i*n + j + 1;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				System.out.print(matrix[i][j] + " " );
			}
			System.out.println();
		}
	}

}