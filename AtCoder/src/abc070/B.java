package abc070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArray = br.readLine().split(" ");

		int[] input = new int [4];

		for(int i = 0; i < 4; i++){
			input[i] = Integer.parseInt(strArray[i]);
		}

		int on = Math.max(input[0], input[2]);
		int off = Math.min(input[1], input[3]);

		System.out.println(Math.max(off-on, 0));
	}

}