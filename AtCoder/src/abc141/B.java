package abc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();

		boolean easy = true;
		for(int i = 0; i < str.length; i++){
			if(i % 2 == 0 && str[i] == 'L'){
				easy = false;
				break;
			}
			if(i % 2 == 1 && str[i] == 'R'){
				easy = false;
				break;
			}
		}

		if(easy){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
