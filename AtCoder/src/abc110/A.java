package abc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int input[] = new int[3];
		for(int i = 0; i < 3; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		Arrays.sort(input);

		System.out.println(input[0]+ input[1]+input[2]*10);
	}

}
