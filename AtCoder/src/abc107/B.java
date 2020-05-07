package abc107;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char matrix[][] = new char[h][w];
		for(int i = 0; i < h; i++){
			String str = sc.next();
			for(int j = 0; j < w ; j++){
				matrix[i][j] = str.charAt(j);
			}
		}

		boolean skipR[] = new boolean[h];
		boolean skipC[] = new boolean[w];
		for(int i = 0; i < h; i++){
			int count = 0;

			for(int j = 0; j < w; j++){
				if(matrix[i][j] == '#'){
					count++;
					break;
				}
			}

			if(count == 0){
				skipR[i] = true;
			}
		}

		for(int j = 0; j < w; j++){
			int count = 0;

			for(int i = 0; i < h; i++){
				if(matrix[i][j] == '#'){
					count++;
					break;
				}
			}

			if(count == 0){
				skipC[j] = true;
			}
		}

		for(int i = 0; i < h; i++){
			if(skipR[i]){
				continue;
			}

			for(int j = 0; j < w; j++){
				if(skipC[j]){
					continue;
				}

				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
