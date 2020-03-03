package abc132;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		char[] input = br.readLine().toCharArray();

		Arrays.sort(input);

		if(input[0] == input[1] && input[1] != input[2] && input[2] == input[3]){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
