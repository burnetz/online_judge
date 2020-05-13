package abc069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		int n = Integer.parseInt(tmp);

		int[] input = new int[n];

		String[] tmpArray = br.readLine().split(" ");

		int numOf4Times = 0;
		int numOfOdd = 0;
		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
			if(input[i] % 2 == 1){
				numOfOdd++;
			}
			else if(input[i] % 4 == 0){
				numOf4Times++;
			}
		}

		if(n % 2 == 1){
			if(numOfOdd - numOf4Times <= 1){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}

		else {
			if(numOfOdd - numOf4Times <= 0){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}

	}

}