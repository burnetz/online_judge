package abc132;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] input = new int[n];

		String[] tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		int count = 0;

		for(int i = 1; i <= n - 2; i++){
			if((input[i] > input[i - 1] && input[i] < input[i + 1]) ||
					(input[i] < input[i - 1] && input[i] > input[i + 1])){
				count++;
			}
		}

		System.out.println(count);
	}

}
