package abc138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] tmpArray = br.readLine().split(" ");

		double[] input = new double[n];
		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		Arrays.sort(input);

		//価値が低い順に合成していくのが最もお得
		//（価値が高いものを何度も割り算してしまうのは勿体ないため）
		for(int i = 1; i < n; i++){
			input[i] = (input[i] + input[i - 1])/2;
		}

		System.out.printf("%.6f\n", input[n - 1]);
	}

}
