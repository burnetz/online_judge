package abc113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int x = Integer.parseInt(tmpArray[0]);
		int y = Integer.parseInt(tmpArray[1]);

		System.out.println(x+y/2);
	}

}
