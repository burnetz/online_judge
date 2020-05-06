package abc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);
		int x = Integer.parseInt(tmpArray[2]);
		int y = Integer.parseInt(tmpArray[3]);

		int inputX[] = new int[n];
		int inputY[] = new int[m];

		tmpArray = br.readLine().split(" ");

		for(int i = 0; i < n; i++){
			inputX[i] = Integer.parseInt(tmpArray[i]);
		}

		tmpArray = br.readLine().split(" ");

		for(int i = 0; i < m; i++){
			inputY[i] = Integer.parseInt(tmpArray[i]);
		}

		Arrays.sort(inputX);
		Arrays.sort(inputY);


		for(int i = x + 1; i <= y; i++){
			if(i > inputX[n - 1] && i <= inputY[0]){
				System.out.println("No War");
				return;
			}
		}

		System.out.println("War");
	}

}
