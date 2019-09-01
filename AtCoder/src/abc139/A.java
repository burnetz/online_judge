package abc139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();
		
		int count = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == t.charAt(i)){
				count++;
			}
		}


		System.out.println(count);
	}

}
