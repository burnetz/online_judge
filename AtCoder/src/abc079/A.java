package abc079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] chars = input.toCharArray();

		if(chars[1] == chars[2] && (chars[0] == chars[1] || chars[2] == chars[3])){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}