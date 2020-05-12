package abc073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		if(input.contains("9")){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}