package abc080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] tmpArray = input.split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int a = Integer.parseInt(tmpArray[1]);
		int b = Integer.parseInt(tmpArray[2]);

		System.out.println(Math.min(n*a, b));
	}

}