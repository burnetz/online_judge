package abc080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int n = Integer.parseInt(input);

		int fx = 0;
		char[] array = input.toCharArray();
		for(int i = 0; i < input.length(); i++){
			fx += array[i] - '0';
		}
		if(n % fx == 0){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}