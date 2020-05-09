package abc096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmpArray = br.readLine().split(" ");

		int input[] = new int[3];
		input[0] = Integer.parseInt(tmpArray[0]);
		input[1] = Integer.parseInt(tmpArray[1]);
		input[2] = Integer.parseInt(tmpArray[2]);

		Arrays.sort(input);

		int k = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0; i < k; i++){
			input[2] *= 2;
		}

		for(int i = 0; i < 3; i++){
			result += input[i];
		}
		System.out.println(result);
	}

}
