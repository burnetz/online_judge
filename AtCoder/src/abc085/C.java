package abc085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] tmpArray = input.split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int y = Integer.parseInt(tmpArray[1]);

		//10000
		for(int i = 0; i <= n ; i++){
			//5000
			for(int j = 0; j <= n - i; j++){
				int sum = i*10000 + j*5000 + (n - i - j)*1000;

				if(sum == y){
					System.out.println(i + " " + j + " " + (n - i - j));
					return;
				}
			}
		}

		System.out.println("-1 -1 -1");
	}

}