package abc076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int rate = Integer.parseInt(input);
		int goal = Integer.parseInt(br.readLine());

		System.out.println(rate + (goal - rate) * 2);

	}

}