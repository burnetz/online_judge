package hhkb2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char[][] matrix = new char[h][];

		for(int i = 0; i < h; i++){
			matrix[i] = sc.next().toCharArray();
		}

		int count = 0;

		for(int i = 0; i < h ; i++){
			for(int j = 0; j < w ; j++){
				if(matrix[i][j] == '.'){
					if(j < w - 1 && matrix[i][j + 1] == '.'){
						count++;
					}
					if(i < h - 1 && matrix[i + 1][j] == '.'){
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

}
