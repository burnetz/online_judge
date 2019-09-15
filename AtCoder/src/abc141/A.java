package abc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		if(str.equals("Sunny")){
			System.out.println("Cloudy");
		}

		else if(str.equals("Cloudy")){
			System.out.println("Rainy");
		}
		else {
			System.out.println("Sunny");
		}
	}

}
