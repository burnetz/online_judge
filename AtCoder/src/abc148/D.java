package abc148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] tmpArray = br.readLine().split(" ");
		
		int input[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(tmpArray[i]);
		}
		
		//前から見ていって1,2,3,4,がどこまで続くかが答え
		int target = 1;
		int length = 0;
		for(int i = 0; i < n; i++) {
			if(input[i] == target) {
				target++;
				length++;
			}
		}
		
		System.out.println(length > 0 ? n - length : -1);
	}
}
