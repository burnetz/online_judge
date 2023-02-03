package codefes2017quala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		if(input.length() <= 3){
			System.out.println("No");
		}
		
		else if(input.subSequence(0, 4).equals("YAKI")){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
