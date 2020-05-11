package abc084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] tmpArray = input.split(" ");
		int a = Integer.parseInt(tmpArray[0]);
		int b = Integer.parseInt(tmpArray[1]);

		String posStr = br.readLine();

		String ptnStr = "\\d{"+a+"}-\\d{"+b+"}";

		if(Pattern.matches(ptnStr, posStr)){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}