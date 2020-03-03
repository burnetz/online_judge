package abc133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int d = Integer.parseInt(tmpArray[1]);

		int input[][] = new int[n][d];

		HashSet<Integer> square = new HashSet<Integer>();

		for(int i = 0; i < 150; i++){
			square.add(i*i);
		}
		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");

			for(int j = 0; j < d; j++){
				input[i][j] = Integer.parseInt(tmpArray[j]);
			}
		}

		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				int distSq = 0;

				for(int k = 0; k < d; k++){
					distSq += Math.pow(input[i][k] - input[j][k], 2);
				}

				if(square.contains(distSq)){
					count++;
				}
			}
		}

		System.out.println(count);
	}

}
