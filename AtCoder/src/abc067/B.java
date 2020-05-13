package abc067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpStr = br.readLine().split(" ");

		int n = Integer.parseInt(tmpStr[0]);
		int k = Integer.parseInt(tmpStr[1]);

		int[] length = new int[n];
		tmpStr = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			length[i] = Integer.parseInt(tmpStr[i]);
		}

		Arrays.sort(length);

		int sum = 0;
		for(int i = 1; i <= k; i++){
			sum += length[length.length - i];
		}
		System.out.println(sum);
	}

}