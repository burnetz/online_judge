package abc067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpStr = br.readLine().split(" ");

		int a = Integer.parseInt(tmpStr[0]);
		int b = Integer.parseInt(tmpStr[1]);

		if(a % 3 == 0 || b % 3 == 0 || (a+b) % 3 == 0){
			System.out.println("Possible");
		}
		else {
			System.out.println("Impossible");
		}
	}

}