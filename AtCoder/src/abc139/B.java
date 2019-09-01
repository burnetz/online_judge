package abc139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int a = Integer.parseInt(tmpArray[0]);
		int b = Integer.parseInt(tmpArray[1]);
		
		if(b == 1){
			System.out.println(0);
			return;
		}
		
		for(int i = 1; ; i++){
			if((a - 1)*(i - 1) + a >= b){
				System.out.println(i);
				return;
			}
		}
	}

}
