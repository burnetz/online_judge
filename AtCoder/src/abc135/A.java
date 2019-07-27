package abc135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		
		int a = Integer.parseInt(tmpArray[0]);
		int b = Integer.parseInt(tmpArray[1]);
		
		if((a - b)%2 == 0){
			System.out.println((a+b)/2);
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
	}

}
