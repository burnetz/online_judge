package abc072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < input.length() ; i+= 2){
			sb.append(input.charAt(i));
		}

		System.out.println(sb.toString());
	}

}