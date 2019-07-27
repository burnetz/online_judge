package abc135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] tmpArray = br.readLine().split(" ");
		
		int input[] = new int[n];
		
		int diff = 0;
		for(int i = 1; i <= n; i++){
			input[i - 1] = Integer.parseInt(tmpArray[i - 1]);
			if(input[i - 1] != i){
				diff++;
			}
		}
		
		if(diff <= 2){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
