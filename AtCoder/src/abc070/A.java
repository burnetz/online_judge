package abc070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		StringBuffer inputBf = new StringBuffer(input);
		StringBuffer reverse = inputBf.reverse();
		String reverseStr = reverse.toString();

		if(input.equals(reverseStr)){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}