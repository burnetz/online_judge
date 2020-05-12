package abc075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String[] tmpArray = input.split(" ");

		if(tmpArray[1].equals(tmpArray[2])){
			System.out.println(tmpArray[0]);
		}
		if(tmpArray[2].equals(tmpArray[0])){
			System.out.println(tmpArray[1]);
		}
		if(tmpArray[1].equals(tmpArray[0])){
			System.out.println(tmpArray[2]);
		}

	}

}