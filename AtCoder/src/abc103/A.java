package abc103;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = new int[3];

		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 3; i++){
			input[i] = sc.nextInt();
		}

		int order[][] = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < order.length; i++){
			int tmpTotal = 0;
			int prev = input[order[i][0]];

			for(int j = 1; j < 3; j++){
				tmpTotal += Math.abs(prev - input[order[i][j]]);
			}

			result = Math.min(result, tmpTotal);
		}

		System.out.println(result);
	}



}
