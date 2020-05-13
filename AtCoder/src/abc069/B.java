package abc069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		System.out.println(input.substring(0, 1)+(input.length()-2)+input.substring(input.length() - 1, input.length()));

	}

}