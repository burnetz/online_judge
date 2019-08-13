package abc137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int k = Integer.parseInt(tmpArray[0]);
		int x = Integer.parseInt(tmpArray[1]);

		for(int i = x - k + 1; i <= x + k - 1; i++){
			if(i != x - k + 1){
				System.out.print(" ");
			}
			System.out.print(i);
		}
		System.out.println();
	}

}
