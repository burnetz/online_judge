package abc074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int distSum = 0;
		String[] tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			int ballPos = Integer.parseInt(tmpArray[i]);

			distSum += Math.min(ballPos, k-ballPos)*2;
		}

		System.out.println(distSum);
	}

}