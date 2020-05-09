package abc099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String result = null;
		if(n <= 999){
			result = "ABC";
		}
		else {
			result = "ABD";
		}
		System.out.println(result);
	}



}
