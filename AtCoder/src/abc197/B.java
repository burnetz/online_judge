package abc197;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;

		char[][] matrix = new char[h][];
		for(int i = 0; i < h; i++){
			matrix[i] = sc.next().toCharArray();
		}

		int count = 1;

		for(int i = x - 1; i >= 0; i--){
			if(matrix[i][y] == '#'){
				break;
			}
			count++;
		}
		for(int i = x + 1; i < h; i++){
			if(matrix[i][y] == '#'){
				break;
			}
			count++;
		}
		for(int i = y - 1; i >= 0; i--){
			if(matrix[x][i] == '#'){
				break;
			}
			count++;
		}
		for(int i = y + 1; i < w ; i++){
			if(matrix[x][i] == '#'){
				break;
			}
			count++;
		}

		System.out.println(count);
	}

}
